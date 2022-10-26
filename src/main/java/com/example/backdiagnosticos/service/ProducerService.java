package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Diagnostico;

public interface ProducerService {
    Object sendMsg(String idObject, String exchangeName);
}
