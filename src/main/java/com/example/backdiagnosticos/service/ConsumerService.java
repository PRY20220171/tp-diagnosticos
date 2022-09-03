package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Diagnostico;

import java.util.UUID;

public interface ConsumerService {
    Object consumerMessage(UUID proId) throws Exception;
}
