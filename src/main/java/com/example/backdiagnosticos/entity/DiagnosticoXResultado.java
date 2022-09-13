package com.example.backdiagnosticos.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = DiagnosticoXResultado.class)
public class DiagnosticoXResultado  implements Serializable {

    @ApiModelProperty(value="Llave compuesta que vincula tratamiento y resultado", dataType="DiagnosticoXResultadoKey", position=0)
    @PrimaryKey
    DiagnosticoResultadoKey diagnosticoResultadoKey;
/*
    @ManyToOne
    @MapsId("iddiagnostico")
    @JoinColumn(name = "iddiagnostico")

    @ManyToOne
    @MapsId("idprueba")
    @JoinColumn(name = "idprueba")

    @ApiModelProperty(value="Es el ID del diagnostico del paciente", dataType="uuid", position=1)
    @NotEmpty(message = "El ID del diagnostico no puede ser vacio")
    @NotNull(message = "El ID del diagnostico no puede ser nulo")
    //@Column("iddiagnostico")
    @MapsId("iddiagnostico")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID iddiagnostico;

    @ApiModelProperty(value="Es el ID del resultado del tratamiento del paciente", dataType="uuid", position=2)
    @NotEmpty(message = "El ID del resultado no puede ser vacio")
    @NotNull(message = "El ID del resultado no puede ser nulo")
    //@Column("idresultado")
    @MapsId("idresultado")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID idresultado;
 */

    @ApiModelProperty(value="Es el motivo por el que determinado diagnostico concluye en determinado resultado", dataType="text", position=3)
   // @NotEmpty(message = "El motivo no puede ser vacio")
   // @NotNull(message = "El motivo no puede ser nulo")
    @Column( "motivo")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String motivo;

}
