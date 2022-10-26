package com.example.backdiagnosticos.service.impl;

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
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsumerServiceImpl /*implements ConsumerService */{
    /*
    @Autowired
    private DiagnosticoService diagnosticoService;

    @Override
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${spring.rabbitmq.queue}",durable = "true"),
                    exchange = @Exchange(value = "${spring.rabbitmq.exchange}"),
                    key = "${spring.rabbitmq.routingkey}")
    )
    public Object consumerMessage(String objId) throws AmqpIOException {
        System.out.println("=============== Message ==================");
        System.out.println(objId);
        System.out.println("==========================================");
        Object obj= diagnosticoService.getDiagnostico(UUID.fromString(objId));
        if(obj==null){
            return null;
        }
        else{
            ObjectMapper objmap = new ObjectMapper();
            try {
                return objmap.writeValueAsString(obj);
            }catch(JsonProcessingException e){
                return null;
            }
        }
    }*/
}