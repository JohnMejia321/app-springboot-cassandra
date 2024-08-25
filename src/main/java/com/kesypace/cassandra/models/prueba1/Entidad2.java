package com.kesypace.cassandra.models.prueba1;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("entidad2")
@Data
public class Entidad2 {
    @PrimaryKey
    private String id;
    private String descripcion;
}