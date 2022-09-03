package com.example.backdiagnosticos.service;

import com.example.backdiagnosticos.entity.Ubicacion;

import java.util.List;
import java.util.UUID;

public interface UbicacionService {
    List<Ubicacion> findUbicacionAll();
    Ubicacion getUbicacion(UUID id);
    Ubicacion createUbicacion(Ubicacion paciente);
    Ubicacion updateUbicacion(Ubicacion paciente);
    String deleteUbicacion(UUID id);
    List<DiagnosticoXResultado> findAllByIddiagnosticoAndIdresultado(UUID iddiagnostico, UUID idresultado);
    /*
    Ubicacion getByDni(Long dni);
    Ubicacion getByDocExtranjeria(Long docnum);
     */
}
