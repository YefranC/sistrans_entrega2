package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.OrdenServicioEntity;
import uniandes.edu.co.epsandes.services.OrdenServicioService;
import java.util.List;

@RestController
@RequestMapping("/ordenservicios")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioService ordenServicioService;
    
    @PostMapping
    public ResponseEntity<OrdenServicioEntity> registrarOrdenServicio(@RequestBody OrdenServicioEntity orden) {
        return ResponseEntity.ok(ordenServicioService.registrarOrdenServicio(orden));
    }
    
    @GetMapping
    public ResponseEntity<List<OrdenServicioEntity>> listarOrdenServicios(){
        return ResponseEntity.ok(ordenServicioService.listarOrdenServicios());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrdenServicioEntity> actualizarOrdenServicio(@PathVariable("id") Integer id, @RequestBody OrdenServicioEntity orden) {
        orden.setIdOrden(id);
        return ResponseEntity.ok(ordenServicioService.actualizarOrdenServicio(orden));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOrdenServicio(@PathVariable("id") Integer id) {
        ordenServicioService.eliminarOrdenServicio(id);
        return ResponseEntity.ok("Orden de servicio eliminada con éxito");
    }
}

