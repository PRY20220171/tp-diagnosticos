package com.example.backdiagnosticos.repository;

import com.example.backdiagnosticos.entity.DiagnosticoXResultado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface DiagnosticoXResultadoRepository extends CrudRepository<DiagnosticoXResultado, UUID> {
    //DiagnosticoXResultado findOneById(String id);
    List<DiagnosticoXResultado> findAllByIddiagnosticoAndIdresultado(UUID iddiagnostico, UUID idresultado);
    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
