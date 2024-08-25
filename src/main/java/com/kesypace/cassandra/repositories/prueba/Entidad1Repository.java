package com.kesypace.cassandra.repositories.prueba;


import com.kesypace.cassandra.models.prueba.Entidad1;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface Entidad1Repository extends CassandraRepository<Entidad1, String> {
}