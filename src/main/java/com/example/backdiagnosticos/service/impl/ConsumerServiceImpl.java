package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.Diagnostico;
import com.example.backdiagnosticos.service.ConsumerService;
import com.example.backdiagnosticos.service.DiagnosticoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpIOException;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @Override
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${spring.rabbitmq.queue}",durable = "true"),
                    exchange = @Exchange(value = "${spring.rabbitmq.exchange}"),
                    key = "${spring.rabbitmq.routingkey}")
    )
    public Object consumerMessage(UUID proId) throws AmqpIOException {
        System.out.println("=============== Message ==================");
        System.out.println(proId);
        System.out.println("==========================================");
        Diagnostico product= diagnosticoService.getDiagnostico(proId);
        if(product==null){
            return null;
        }
        else{
            ObjectMapper obj = new ObjectMapper();
            try {
                String pro = obj.writeValueAsString(product);
                return pro;
            }catch(JsonProcessingException e){
                return null;
            }
        }
    }
}