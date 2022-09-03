package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Diagnostico;

public interface ProducerService {
    //Object sendMsg(Long proId) throws Exception;

    void sendMsg(Diagnostico object);
}
