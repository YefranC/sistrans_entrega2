package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.MedicoEntity;
import uniandes.edu.co.epsandes.services.MedicoService;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    
    @PostMapping
    public ResponseEntity<MedicoEntity> registrarMedico(@RequestBody MedicoEntity medico) {
        return ResponseEntity.ok(medicoService.registrarMedico(medico));
    }
    
    @GetMapping
    public ResponseEntity<List<MedicoEntity>> listarMedicos(){
        return ResponseEntity.ok(medicoService.listarMedicos());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedicoEntity> actualizarMedico(@PathVariable("id") Integer id, @RequestBody MedicoEntity medico) {
        medico.setIdMedico(id);
        return ResponseEntity.ok(medicoService.actualizarMedico(medico));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMedico(@PathVariable("id") Integer id) {
        medicoService.eliminarMedico(id);
        return ResponseEntity.ok("Médico eliminado con éxito");
    }
}

