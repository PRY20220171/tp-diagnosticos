package com.example.backdiagnosticos.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backdiagnosticos.entity.DiagnosticoXResultado;
import com.example.backdiagnosticos.service.DiagnosticoXResultadoService;
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
@RequestMapping("/diagnosticosxresultados")
public class DiagnosticoXResultadoController {
    @Autowired
    private DiagnosticoXResultadoService diagnosticoxresultadoService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de una diagnosticoxresultado por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=DiagnosticoXResultado.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<DiagnosticoXResultado>> listDiagnosticoXResultado(@RequestParam(name="iddiagresul",required = false) String idDiagresul){
        List<DiagnosticoXResultado> diagnosticoxresultados=new ArrayList<>();
        if(null==idDiagresul){
            diagnosticoxresultados=diagnosticoxresultadoService.findDiagnosticoXResultadoAll();
            if(diagnosticoxresultados.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            diagnosticoxresultados = Collections.singletonList(diagnosticoxresultadoService.getDiagnosticoXResultado(UUID.fromString(idDiagresul)));
        }
        return ResponseEntity.ok(diagnosticoxresultados);
    }

    @PostMapping
    public ResponseEntity<DiagnosticoXResultado> createDiagnosticoXResultado(@Valid @RequestBody DiagnosticoXResultado diagnosticoxresultado, BindingResult result){
        diagnosticoxresultado.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        DiagnosticoXResultado diagnosticoxresultadocreate = diagnosticoxresultadoService.createDiagnosticoXResultado(diagnosticoxresultado);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticoxresultadocreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoXResultado> updateDiagnosticoXResultado(@PathVariable("id") String id, @RequestBody DiagnosticoXResultado diagnosticoxresultado){
        diagnosticoxresultado.setId(UUID.fromString(id));
        DiagnosticoXResultado diagnosticoxresultadoDB=diagnosticoxresultadoService.updateDiagnosticoXResultado(diagnosticoxresultado);
        if(diagnosticoxresultadoDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoxresultadoDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiagnosticoXResultado(@PathVariable("id") String id){
        String diagnosticoxresultadoDelete=diagnosticoxresultadoService.deleteDiagnosticoXResultado(UUID.fromString(id));
        if(diagnosticoxresultadoDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosticoxresultadoDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new DiagnosticoXResultado());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }



}
