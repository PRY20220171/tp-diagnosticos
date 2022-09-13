package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Diagnostico;

import java.util.UUID;

public interface ConsumerService {
    Object consumerMessage(String objId) throws Exception;
}
