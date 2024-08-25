package com.kesypace.cassandra.services.prueba;



import com.kesypace.cassandra.models.prueba.Entidad1;
import com.kesypace.cassandra.repositories.prueba.Entidad1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Entidad1Service {
    @Autowired
    private Entidad1Repository entidad1Repository;

    public Entidad1 guardar(Entidad1 entidad1) {
        return entidad1Repository.save(entidad1);
    }

    public Entidad1 buscarPorId(String id) {
        return entidad1Repository.findById(id).orElse(null);
    }

    public List<Entidad1> mostrarTodos(){
        return entidad1Repository.findAll();
    }
}