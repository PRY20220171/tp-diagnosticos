package com.example.backdiagnosticos.repository;

import com.example.backdiagnosticos.entity.DiagnosticoResultadoKey;
import com.example.backdiagnosticos.entity.DiagnosticoXResultado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiagnosticoXResultadoRepository extends CrudRepository<DiagnosticoXResultado, DiagnosticoResultadoKey> {
    List<DiagnosticoXResultado> findAllByDiagnosticoResultadoKey_Iddiagnostico(UUID iddiagnostico);
    List<DiagnosticoXResultado> findAllByDiagnosticoResultadoKey_Idresultado(UUID idresultado);
}
