package com.example.backdiagnosticos.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backdiagnosticos.entity.Diagnostico;
import com.example.backdiagnosticos.service.DiagnosticoService;
import com.example.backdiagnosticos.service.ProducerService;
import com.example.backdiagnosticos.util.ErrorMessage;
import com.example.backdiagnosticos.util.Message;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos del diagnostico del paciente por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Diagnostico.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Diagnostico>> listDiagnostico(@RequestParam(name="iddiagnostico",required = false) String idDiagnostico){
        List<Diagnostico> diagnosticos=new ArrayList<>();
        if(null==idDiagnostico){
            diagnosticos=diagnosticoService.findDiagnosticoAll();
            if(diagnosticos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            diagnosticos = Collections.singletonList(diagnosticoService.getDiagnostico(UUID.fromString(idDiagnostico)));
        }
        return ResponseEntity.ok(diagnosticos);
    }

    @PostMapping
    public ResponseEntity<Diagnostico> createDiagnostico(@Valid @RequestBody Diagnostico diagnostico, BindingResult result){
        diagnostico.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Diagnostico diagnosticocreate = diagnosticoService.createDiagnostico(diagnostico);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticocreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diagnostico> updateDiagnostico(@PathVariable("id") String id, @RequestBody Diagnostico diagnostico){
        diagnostico.setId(UUID.fromString(id));
        Diagnostico diagnosticoDB=diagnosticoService.updateDiagnostico(diagnostico);
        if(diagnosticoDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiagnostico(@PathVariable("id") String id){
        String diagnosticoDelete=diagnosticoService.deleteDiagnostico(UUID.fromString(id));
        if(diagnosticoDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoDelete);
    }
/*
    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new Diagnostico());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
 */



}
