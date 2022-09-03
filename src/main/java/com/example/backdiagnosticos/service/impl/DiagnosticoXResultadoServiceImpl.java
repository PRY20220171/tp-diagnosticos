package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.DiagnosticoXResultado;
import com.example.backdiagnosticos.repository.DiagnosticoXResultadoRepository;
import com.example.backdiagnosticos.service.DiagnosticoXResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosticoXResultadoServiceImpl implements DiagnosticoXResultadoService {
    @Autowired
    private DiagnosticoXResultadoRepository diagnosticoxresultadoRepository;

    @Override
    public List<DiagnosticoXResultado> findDiagnosticoXResultadoAll() {
        return (List<DiagnosticoXResultado>) diagnosticoxresultadoRepository.findAll();
    }

    @Override
    public DiagnosticoXResultado getDiagnosticoXResultado(UUID id) {
        return diagnosticoxresultadoRepository.findById(id).orElse(null);
    }

    @Override
    public DiagnosticoXResultado createDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxresultado) {
        //Aquí irian las validaciones al crear el diagnosticoxresultado de ser necesario
        return diagnosticoxresultadoRepository.save(diagnosticoxresultado);
    }

    @Override
    public DiagnosticoXResultado updateDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxresultado) {
        DiagnosticoXResultado diagnosticoxresultadoDB = this.getDiagnosticoXResultado(diagnosticoxresultado.getId());
        if (diagnosticoxresultadoDB == null) {
            return null;
        }
        //Actualizamos los valores del diagnosticoxresultado:
        diagnosticoxresultadoDB.setIddiagnostico(diagnosticoxresultado.getIddiagnostico());
        diagnosticoxresultadoDB.setIdresultado(diagnosticoxresultado.getIdresultado());
        diagnosticoxresultadoDB.setMotivo(diagnosticoxresultado.getMotivo());
        return diagnosticoxresultadoRepository.save(diagnosticoxresultado);
    }

    @Override
    public String deleteDiagnosticoXResultado(UUID id) {
        DiagnosticoXResultado diagnosticoxresultadoDB = this.getDiagnosticoXResultado(id);
        if (diagnosticoxresultadoDB == null) {
            return null;
        }
        try{
            diagnosticoxresultadoRepository.delete(diagnosticoxresultadoDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
    //public List<DiagnosticoXResultado> findAllByIddiagnosticoAndIdresultado(UUID iddiagnostico, UUID idresultado);
   
}
