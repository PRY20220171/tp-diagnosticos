package com.example.backdiagnosticos.repository;

import com.example.backdiagnosticos.entity.Diagnostico;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface DiagnosticoRepository extends CrudRepository<Diagnostico, UUID> {
    @AllowFiltering
    Diagnostico findDiagnosticoByAtencionId(UUID atencionId);
    //Diagnostico findOneById(String id);
    //Diagnostico findAllByDoctipoAndDocnum(String doctipo, String docnum);
    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
