package com.example.backdiagnosticos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

//import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Diagnostico.class)
public class Diagnostico implements Serializable {

    @ApiModelProperty(value = "ID del diagnostico del paciente", dataType = "uuid", position = 1)
    @Id
    @Column("iddiagnostico")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value = "Es la fecha de registro del diagnostico del paciente", dataType = "date", position = 2)
    @NotNull(message = "La fecha de registro no puede ser nula")
    @Column("fecregistro")
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate fecregistro;

    @ApiModelProperty(value = "Es la descripcion del diagnostico del paciente", dataType = "ascii", position = 3)
    @NotEmpty(message = "La descripcion no puede ser vacio")
    @NotNull(message = "La descripcion no puede ser nula")
    @Column("descripcion")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String descripcion;

    @ApiModelProperty(value = "Es el estado del diagnostico del paciente", dataType = "text", example = "en proceso", position = 4)
    @NotEmpty(message = "El estado no puede ser vacio")
    @NotNull(message = "El estado no puede ser nulo")
    @Column("estado")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String estado;

    @ApiModelProperty(value = "Es el tipo del diagnostico del paciente", dataType = "ascii", example = "inicial", position = 5)
    @NotEmpty(message = "El tipo no puede ser vacio")
    @NotNull(message = "El tipo no puede ser nulo")
    @Column("tipo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tipo;

    @ApiModelProperty(value = "Es el ID de la atencion", dataType = "uuid", position = 6)
    @NotNull(message = "El ID de la atencion no puede ser nulo")
    @Column("atencionid")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID atencionId;

    @ApiModelProperty(value = "Es el ID del resultado", dataType = "uuid", position = 6)
    @NotNull(message = "El ID del resultado no puede ser nulo")
    @Column("resultadoId")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID resultadoId;
    @Transient
    private Resultado resultado;

    @ApiModelProperty(value = "Es el ID de la prueba", dataType = "uuid", position = 6)
    @NotNull(message = "El ID de la prueba no puede ser nulo")
    @Column("pruebaId")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID pruebaId;
    @Transient
    private Prueba prueba;

/*
    @ManyToMany
    Set<Prueba> pruebas;

    @OneToMany(mappedBy = "diagnostico")
    Set<DiagnosticoXPrueba> motivos;
*/
}
