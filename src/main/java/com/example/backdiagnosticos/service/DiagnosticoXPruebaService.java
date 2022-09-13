package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.DiagnosticoPruebaKey;
import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoXPruebaService {
    List<DiagnosticoXPrueba> findDiagnosticoXPruebaAll();
    List<DiagnosticoXPrueba> getDiagnosticoXPruebaByIdDiagnostico(UUID iddiagnostico);
    List<DiagnosticoXPrueba> getDiagnosticoXPruebaByIdPrueba(UUID idprueba);
    DiagnosticoXPrueba getDiagnosticoXPrueba(UUID iddiagnostico,UUID idprueba);
    DiagnosticoXPrueba getDiagnosticoXPrueba(DiagnosticoPruebaKey key);
    DiagnosticoXPrueba createDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba);
    DiagnosticoXPrueba updateDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba);
    String deleteDiagnosticoXPrueba(UUID iddiagnostico,UUID idprueba);
    String deleteDiagnosticoXPrueba(DiagnosticoPruebaKey key);
}
