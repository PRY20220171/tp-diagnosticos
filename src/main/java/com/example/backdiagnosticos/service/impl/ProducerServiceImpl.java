package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.Diagnostico;
import com.example.backdiagnosticos.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private Environment environment;
    @Autowired
    private DirectExchange exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String sendMsg(String idObj, String exchangeName) {
        try {
            Object response = amqpTemplate.convertSendAndReceive(exchangeName, routingkey, idObj);
            if (response != null) {
                //return objectMapper.readValue(response.toString(), Diagnostico.class);
                return response.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
