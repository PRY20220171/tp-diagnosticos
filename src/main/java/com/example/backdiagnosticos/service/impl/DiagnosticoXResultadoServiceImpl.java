package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.DiagnosticoResultadoKey;
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
    public List<DiagnosticoXResultado> getDiagnosticoXResultadoByIdDiagnostico(UUID iddiagnostico){
        return diagnosticoxresultadoRepository.findAllByDiagnosticoResultadoKey_Iddiagnostico(iddiagnostico);
    }
    @Override
    public List<DiagnosticoXResultado> getDiagnosticoXResultadoByIdResultado(UUID idresultado){
        return diagnosticoxresultadoRepository.findAllByDiagnosticoResultadoKey_Idresultado(idresultado);
    }
    @Override
    public DiagnosticoXResultado getDiagnosticoXResultado(UUID iddiagnostico,UUID idprueba){
        return diagnosticoxresultadoRepository.findById(new DiagnosticoResultadoKey(iddiagnostico,idprueba)).orElse(null);
    }

    @Override
    public DiagnosticoXResultado getDiagnosticoXResultado(DiagnosticoResultadoKey key) {
        return diagnosticoxresultadoRepository.findById(key).orElse(null);
    }

    @Override
    public DiagnosticoXResultado createDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxresultado) {
        //Aquí irian las validaciones al crear el diagnosticoxresultado de ser necesario
        return diagnosticoxresultadoRepository.save(diagnosticoxresultado);
    }

    @Override
    public DiagnosticoXResultado updateDiagnosticoXResultado(DiagnosticoXResultado diagnosticoxresultado) {
        DiagnosticoXResultado diagnosticoxresultadoDB = this.getDiagnosticoXResultado(diagnosticoxresultado.getDiagnosticoResultadoKey());
        if (diagnosticoxresultadoDB == null) {
            return null;
        }
        diagnosticoxresultadoDB.setMotivo(diagnosticoxresultado.getMotivo());
        return diagnosticoxresultadoRepository.save(diagnosticoxresultado);
    }

    @Override
    public String deleteDiagnosticoXResultado(UUID iddiagnostico,UUID idresultado) {
        DiagnosticoXResultado diagnosticoxresultadoDB = this.getDiagnosticoXResultado(iddiagnostico,idresultado);
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

    @Override
    public String deleteDiagnosticoXResultado(DiagnosticoResultadoKey key) {
        DiagnosticoXResultado diagnosticoxresultadoDB = this.getDiagnosticoXResultado(key);
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
