package com.kesypace.cassandra.models.prueba;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("entidad1")
@Data
public class Entidad1 {
    @PrimaryKey
    private String id;
    private String nombre;

}