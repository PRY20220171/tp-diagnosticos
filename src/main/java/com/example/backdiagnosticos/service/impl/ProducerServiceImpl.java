package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.Diagnostico;
import com.example.backdiagnosticos.service.ProducerService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {
     @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Diagnostico object) {
        amqpTemplate.convertSendAndReceive("salud.diagnosticos.exchange","salud.diagnosticos.routingkey",object);
    }
}
