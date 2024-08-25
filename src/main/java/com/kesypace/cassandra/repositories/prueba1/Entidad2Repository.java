package com.kesypace.cassandra.repositories.prueba1;


import com.kesypace.cassandra.models.prueba1.Entidad2;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface Entidad2Repository extends CassandraRepository<Entidad2, String> {
}