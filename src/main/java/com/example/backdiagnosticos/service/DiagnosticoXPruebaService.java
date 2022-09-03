package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoXPruebaService {
    List<DiagnosticoXPrueba> findDiagnosticoXPruebaAll();
    //DiagnosticoXPrueba getDiagnosticoXPrueba(UUID iddiagnostico,UUID idprueba);
    DiagnosticoXPrueba getDiagnosticoXPrueba(UUID id);
    DiagnosticoXPrueba createDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba);
    DiagnosticoXPrueba updateDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba);
    String deleteDiagnosticoXPrueba(UUID id);
    List<DiagnosticoXPrueba> findAllByIddiagnosticoAndIdprueba(UUID iddiagnostico, UUID idprueba);
}
