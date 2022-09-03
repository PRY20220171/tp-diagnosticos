package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;
import com.example.backdiagnosticos.repository.DiagnosticoXPruebaRepository;
import com.example.backdiagnosticos.service.DiagnosticoXPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosticoXPruebaServiceImpl implements DiagnosticoXPruebaService {
    @Autowired
    private DiagnosticoXPruebaRepository diagnosticoxpruebaRepository;

    @Override
    public List<DiagnosticoXPrueba> findDiagnosticoXPruebaAll() {
        return (List<DiagnosticoXPrueba>) diagnosticoxpruebaRepository.findAll();
    }

    @Override
    public DiagnosticoXPrueba getDiagnosticoXPrueba(UUID id) {
        return diagnosticoxpruebaRepository.findById(id).orElse(null);
    }

    @Override
    public DiagnosticoXPrueba createDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba) {
        //Aquí irian las validaciones al crear el diagnosticoxprueba de ser necesario
        return diagnosticoxpruebaRepository.save(diagnosticoxprueba);
    }

    @Override
    public DiagnosticoXPrueba updateDiagnosticoXPrueba(DiagnosticoXPrueba diagnosticoxprueba) {
        DiagnosticoXPrueba diagnosticoxpruebaDB = this.getDiagnosticoXPrueba(diagnosticoxprueba.getId());
        if (diagnosticoxpruebaDB == null) {
            return null;
        }
        //Actualizamos los valores del diagnosticoxprueba:
        diagnosticoxpruebaDB.setIddiagnostico(diagnosticoxprueba.getIddiagnostico());
        diagnosticoxpruebaDB.setIdprueba(diagnosticoxprueba.getIdprueba());
        diagnosticoxpruebaDB.setMotivo(diagnosticoxprueba.getMotivo());
        return diagnosticoxpruebaRepository.save(diagnosticoxprueba);
    }

    @Override
    public String deleteDiagnosticoXPrueba(UUID id) {
        DiagnosticoXPrueba diagnosticoxpruebaDB = this.getDiagnosticoXPrueba(id);
        if (diagnosticoxpruebaDB == null) {
            return null;
        }
        try{
            diagnosticoxpruebaRepository.delete(diagnosticoxpruebaDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public List<DiagnosticoXPrueba> findAllByIddiagnosticoAndIdprueba(UUID iddiagnostico, UUID idprueba){
        return diagnosticoxpruebaRepository.findAllByIddiagnosticoAndIdprueba("DNI", dni.toString());
    }

 */
}
