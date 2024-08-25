package com.kesypace.cassandra.controllers.prueba;





import com.kesypace.cassandra.models.prueba.Entidad1;
import com.kesypace.cassandra.services.prueba.Entidad1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entidad1")
public class Entidad1Controller {
    @Autowired
    private Entidad1Service entidad1Service;

    @PostMapping
    public Entidad1 crear(@RequestBody Entidad1 entidad1) {
        return entidad1Service.guardar(entidad1);
    }

    @GetMapping("/{id}")
    public Entidad1 obtener(@PathVariable String id) {
        return entidad1Service.buscarPorId(id);
    }

    @GetMapping("/mostrar")
    public List<Entidad1> mostrarTodos(){
        return entidad1Service.mostrarTodos();
    }
}