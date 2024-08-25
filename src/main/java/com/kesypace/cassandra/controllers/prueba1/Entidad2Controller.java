package com.kesypace.cassandra.controllers.prueba1;




import com.kesypace.cassandra.models.prueba1.Entidad2;
import com.kesypace.cassandra.services.prueba1.Entidad2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entidad2")
public class Entidad2Controller {
    @Autowired
    private Entidad2Service entidad2Service;

    @PostMapping
    public Entidad2 crear(@RequestBody Entidad2 entidad2) {
        return entidad2Service.guardar(entidad2);
    }

    @GetMapping("/{id}")
    public Entidad2 obtener(@PathVariable String id) {
        return entidad2Service.buscarPorId(id);
    }

    @GetMapping("/mostrar")
    public List<Entidad2> mostrarTodos(){
        return entidad2Service.mostrarTodos();
    }
}