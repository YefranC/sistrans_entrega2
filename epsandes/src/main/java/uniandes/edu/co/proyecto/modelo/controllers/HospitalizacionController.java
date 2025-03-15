package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.HospitalizacionEntity;
import uniandes.edu.co.epsandes.services.HospitalizacionService;
import java.util.List;

@RestController
@RequestMapping("/hospitalizaciones")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;
    
    @PostMapping
    public ResponseEntity<HospitalizacionEntity> registrarHospitalizacion(@RequestBody HospitalizacionEntity hospitalizacion) {
        HospitalizacionEntity nueva = hospitalizacionService.registrarHospitalizacion(hospitalizacion);
        return ResponseEntity.ok(nueva);
    }
    
    @GetMapping
    public ResponseEntity<List<HospitalizacionEntity>> listarHospitalizaciones(){
        return ResponseEntity.ok(hospitalizacionService.listarHospitalizaciones());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<HospitalizacionEntity> actualizarHospitalizacion(@PathVariable("id") Integer id,
                                                                            @RequestBody HospitalizacionEntity hospitalizacion) {
        hospitalizacion.setIdHospitalizacion(id);
        return ResponseEntity.ok(hospitalizacionService.actualizarHospitalizacion(hospitalizacion));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHospitalizacion(@PathVariable("id") Integer id) {
        hospitalizacionService.eliminarHospitalizacion(id);
        return ResponseEntity.ok("Hospitalización eliminada con éxito");
    }
}

