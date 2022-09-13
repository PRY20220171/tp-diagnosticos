package com.example.backdiagnosticos.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;
import com.example.backdiagnosticos.service.DiagnosticoXPruebaService;
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
@RequestMapping("/diagnosticosxpruebas")
public class DiagnosticoXPruebaController {
    /*
    @Autowired
    private DiagnosticoXPruebaService diagnosticoxpruebaService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de la relacion de un diagnostico con una prueba por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=DiagnosticoXPrueba.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<DiagnosticoXPrueba>> listDiagnosticoXPrueba(@RequestParam(name="iddiagnostico",required = false) String iddiagnostico, @RequestParam(name="idprueba",required = false) String idprueba){
        List<DiagnosticoXPrueba> diagnosticoxpruebas=new ArrayList<>();
        if(null==iddiagnostico && null==idprueba){
            diagnosticoxpruebas=diagnosticoxpruebaService.findDiagnosticoXPruebaAll();
            if(diagnosticoxpruebas.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else if(null==iddiagnostico && (null!=idprueba||!idprueba.isEmpty())){
            diagnosticoxpruebas=diagnosticoxpruebaService.getDiagnosticoXPruebaByIdPrueba(UUID.fromString(idprueba));
            if(diagnosticoxpruebas.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        else if((null!=iddiagnostico||!iddiagnostico.isEmpty()) && null==idprueba){
            diagnosticoxpruebas=diagnosticoxpruebaService.getDiagnosticoXPruebaByIdDiagnostico(UUID.fromString(iddiagnostico));
            if(diagnosticoxpruebas.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        else{
            DiagnosticoXPrueba diagnosticoxprueba=diagnosticoxpruebaService.getDiagnosticoXPrueba(UUID.fromString(iddiagnostico),UUID.fromString(idprueba));
            if(null==diagnosticoxprueba){
                return ResponseEntity.notFound().build();
            }
            diagnosticoxpruebas.add(diagnosticoxprueba);
        }
        return ResponseEntity.ok(diagnosticoxpruebas);
    }

    @PostMapping
    public ResponseEntity<DiagnosticoXPrueba> createDiagnosticoXPrueba(@Valid @RequestBody DiagnosticoXPrueba diagnosticoxprueba, BindingResult result){
        diagnosticoxprueba.setDiagnosticoPruebaKey(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        DiagnosticoXPrueba diagnosticoxpruebacreate = diagnosticoxpruebaService.createDiagnosticoXPrueba(diagnosticoxprueba);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticoxpruebacreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoXPrueba> updateDiagnosticoXPrueba(@PathVariable("id") String id, @RequestBody DiagnosticoXPrueba diagnosticoxprueba){
        diagnosticoxprueba.setId(UUID.fromString(id));
        DiagnosticoXPrueba diagnosticoxpruebaDB=diagnosticoxpruebaService.updateDiagnosticoXPrueba(diagnosticoxprueba);
        if(diagnosticoxpruebaDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoxpruebaDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiagnosticoXPrueba(@PathVariable("id") String id){
        String diagnosticoxpruebaDelete=diagnosticoxpruebaService.deleteDiagnosticoXPrueba(UUID.fromString(id));
        if(diagnosticoxpruebaDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoxpruebaDelete);
    }
/*
    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new DiagnosticoXPrueba());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

 */



}
