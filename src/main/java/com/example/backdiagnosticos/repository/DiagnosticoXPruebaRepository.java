package com.example.backdiagnosticos.repository;

import com.example.backdiagnosticos.entity.DiagnosticoPruebaKey;
import com.example.backdiagnosticos.entity.DiagnosticoXPrueba;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface DiagnosticoXPruebaRepository extends CrudRepository<DiagnosticoXPrueba, DiagnosticoPruebaKey> {
    List<DiagnosticoXPrueba> findAllByDiagnosticoPruebaKey_Iddiagnostico(UUID iddiagnostico);
    List<DiagnosticoXPrueba> findAllByDiagnosticoPruebaKey_Idprueba(UUID idprueba);

}
