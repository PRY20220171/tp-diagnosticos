package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Diagnostico;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoService {
    List<Diagnostico> findDiagnosticoAll();
    Diagnostico getDiagnostico(UUID id);
    Diagnostico getDiagnosticoByAtencionId(UUID atencionId);
    Diagnostico createDiagnostico(Diagnostico diagnostico);
    Diagnostico updateDiagnostico(Diagnostico diagnostico);
    String deleteDiagnostico(UUID id);
}
