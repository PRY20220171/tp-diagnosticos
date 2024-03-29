package com.example.backdiagnosticos.service.impl;

import com.example.backdiagnosticos.entity.Diagnostico;
import com.example.backdiagnosticos.entity.Prueba;
import com.example.backdiagnosticos.entity.Resultado;
import com.example.backdiagnosticos.repository.DiagnosticoRepository;
import com.example.backdiagnosticos.service.DiagnosticoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private ProducerServiceImpl producerService;

    @Override
    public List<Diagnostico> findDiagnosticoAll() {
        return (List<Diagnostico>) diagnosticoRepository.findAll();
    }

    @Override
    public Diagnostico getDiagnostico(UUID id) {

        Diagnostico diagnosticoDB = diagnosticoRepository.findById(id).orElse(null);

        if (diagnosticoDB == null){
            return null;
        }

        String pruebaDB = producerService.sendMsg(diagnosticoDB.getPruebaId().toString(), "pruebas.rpc");

        if (pruebaDB == null){
            return null;
        }

        System.out.println(pruebaDB);

        try {
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JavaTimeModule())
                    .build();
            Prueba prueba = mapper.readValue(pruebaDB, Prueba.class);
            diagnosticoDB.setPrueba(prueba);
        } catch (Exception e){
            System.out.println(e.toString());
            return null;
        }

        String resultadoDB = producerService.sendMsg(diagnosticoDB.getResultadoId().toString(), "resultados.rpc");

        if (resultadoDB == null){
            return null;
        }

        System.out.println(resultadoDB);

        try {
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JavaTimeModule())
                    .build();
            Resultado resultado = mapper.readValue(resultadoDB, Resultado.class);
            diagnosticoDB.setResultado(resultado);
        } catch (Exception e){
            System.out.println(e.toString());
            return null;
        }

        return diagnosticoDB;

    }

    @Override
    public Diagnostico getDiagnosticoByAtencionId(UUID atencionId) {
        return diagnosticoRepository.findDiagnosticoByAtencionId(atencionId);
    }

    @Override
    public Diagnostico createDiagnostico(Diagnostico diagnostico) {
        //Aquí irian las validaciones al crear el diagnostico de ser necesario
        return diagnosticoRepository.save(diagnostico);
    }

    @Override
    public Diagnostico updateDiagnostico(Diagnostico diagnostico) {
        Diagnostico diagnosticoDB = this.getDiagnostico(diagnostico.getId());
        if (diagnosticoDB == null) {
            return null;
        }
        //Actualizamos los valores del diagnostico:
        diagnosticoDB.setFecregistro(diagnostico.getFecregistro());
        diagnosticoDB.setDescripcion(diagnostico.getDescripcion());
        diagnosticoDB.setEstado(diagnostico.getEstado());
        diagnosticoDB.setTipo(diagnostico.getTipo());
        return diagnosticoRepository.save(diagnostico);
    }

    @Override
    public String deleteDiagnostico(UUID id) {
        Diagnostico diagnosticoDB = this.getDiagnostico(id);
        if (diagnosticoDB == null) {
            return null;
        }
        try{
            diagnosticoRepository.delete(diagnosticoDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public Diagnostico getByDni(Long dni) {
        return diagnosticoRepository.findAllByTipoAndEstado("DNI", dni.toString());
    }

    @Override
    public Diagnostico getByDocExtranjeria(Long estado) {
        return diagnosticoRepository.findAllByTipoAndEstado("DOCUMENTO EXTRANJERIA", estado.toString());
    }
 */
}
