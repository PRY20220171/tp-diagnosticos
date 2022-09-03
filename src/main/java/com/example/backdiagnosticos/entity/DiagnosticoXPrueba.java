package com.example.backdiagnosticos.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//import javax.persistence.*;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = DiagnosticoXPrueba.class)
public class DiagnosticoXPrueba  implements Serializable {

    @EmbeddedId
    DiagnosticoPruebaKey iddiagprueba;
/*
    @ManyToOne
    @MapsId("iddiagnostico")
    @JoinColumn(name = "iddiagnostico")
    
    @ManyToOne
    @MapsId("idprueba")
    @JoinColumn(name = "idprueba")
*/  
    @ApiModelProperty(value="Es el ID del diagnostico del paciente", dataType="uuid", position=1)
    @NotEmpty(message = "El ID del diagnostico no puede ser vacio")
    @NotNull(message = "El ID del diagnostico no puede ser nulo")
    //@Column("iddiagnostico")
    @MapsId("iddiagnostico")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID iddiagnostico;

    @ApiModelProperty(value="Es el ID de la prueba medica brindada al paciente", dataType="uuid", position=2)
    @NotEmpty(message = "El ID de la prueba no puede ser vacio")
    @NotNull(message = "El ID de la prueba no puede ser nulo")
    //@Column("idprueba")
    @MapsId("idprueba")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID idprueba;

    @ApiModelProperty(value="Es el motivo por el que determinada prueba da determinado diagnostico", dataType="text", position=3)
   // @NotEmpty(message = "El motivo no puede ser vacio")
   // @NotNull(message = "El motivo no puede ser nulo")
    @Column( "motivo")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String motivo;

}
