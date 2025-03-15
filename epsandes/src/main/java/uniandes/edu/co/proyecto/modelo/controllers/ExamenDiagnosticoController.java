package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.ExamenDiagnosticoEntity;
import uniandes.edu.co.epsandes.services.ExamenDiagnosticoService;
import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenDiagnosticoController {

    @Autowired
    private ExamenDiagnosticoService examenService;
    
    @PostMapping
    public ResponseEntity<ExamenDiagnosticoEntity> registrarExamen(@RequestBody ExamenDiagnosticoEntity examen) {
        return ResponseEntity.ok(examenService.registrarExamen(examen));
    }
    
    @GetMapping
    public ResponseEntity<List<ExamenDiagnosticoEntity>> listarExamenes(){
        return ResponseEntity.ok(examenService.listarExamenes());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExamenDiagnosticoEntity> actualizarExamen(@PathVariable("id") Integer id, @RequestBody ExamenDiagnosticoEntity examen) {
        examen.setIdExamen(id);
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarExamen(@PathVariable("id") Integer id) {
        examenService.eliminarExamen(id);
        return ResponseEntity.ok("Examen eliminado con éxito");
    }
}

