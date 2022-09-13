package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.DiagnosticoResultadoKey;
import com.example.backdiagnosticos.entity.DiagnosticoXResultado;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoXResultadoService {
    List<DiagnosticoXResultado> findDiagnosticoXResultadoAll();
    List<DiagnosticoXResultado> getDiagnosticoXResultadoByIdDiagnostico(UUID iddiagnostico);
    List<DiagnosticoXResultado> getDiagnosticoXResultadoByIdResultado(UUID idresultado);
    DiagnosticoXResultado getDiagnosticoXResultado(UUID iddiagnostico,UUID idprueba);
    DiagnosticoXResultado getDiagnosticoXResultado(DiagnosticoResultadoKey key);
    DiagnosticoXResultado createDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxprueba);
    DiagnosticoXResultado updateDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxprueba);
    String deleteDiagnosticoXResultado(UUID iddiagnostico,UUID idresultado);
    String deleteDiagnosticoXResultado(DiagnosticoResultadoKey key);
}
