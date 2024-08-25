package com.kesypace.cassandra.services.prueba1;




import com.kesypace.cassandra.models.prueba1.Entidad2;
import com.kesypace.cassandra.repositories.prueba1.Entidad2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Entidad2Service {
    @Autowired
    private Entidad2Repository entidad2Repository;

    public Entidad2 guardar(Entidad2 entidad2) {
        return entidad2Repository.save(entidad2);
    }

    public Entidad2 buscarPorId(String id) {
        return entidad2Repository.findById(id).orElse(null);
    }

    public List<Entidad2> mostrarTodos(){
        return entidad2Repository.findAll();
    }
}