package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.ConsultaEntity;
import uniandes.edu.co.epsandes.services.ConsultaService;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    
    @PostMapping
    public ResponseEntity<ConsultaEntity> registrarConsulta(@RequestBody ConsultaEntity consulta) {
        return ResponseEntity.ok(consultaService.registrarConsulta(consulta));
    }
    
    @GetMapping
    public ResponseEntity<List<ConsultaEntity>> listarConsultas(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaEntity> actualizarConsulta(@PathVariable("id") Integer id, @RequestBody ConsultaEntity consulta) {
        consulta.setIdConsulta(id);
        return ResponseEntity.ok(consultaService.actualizarConsulta(consulta));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarConsulta(@PathVariable("id") Integer id) {
        consultaService.eliminarConsulta(id);
        return ResponseEntity.ok("Consulta eliminada con éxito");
    }
}

