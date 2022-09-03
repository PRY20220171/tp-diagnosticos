package com.example.backdiagnosticos.repository;

import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface DiagnosticoXPruebaRepository extends CrudRepository<DiagnosticoXPrueba, UUID> {
    //DiagnosticoXPrueba findOneById(String id);
    List<DiagnosticoXPrueba> findAllByIddiagnosticoAndIdprueba(UUID iddiagnostico, UUID idprueba);
    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
