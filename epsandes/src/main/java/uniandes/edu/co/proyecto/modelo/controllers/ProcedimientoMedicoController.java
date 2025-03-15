package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoEntity;
import uniandes.edu.co.epsandes.services.ProcedimientoMedicoService;
import java.util.List;

@RestController
@RequestMapping("/procedimientos")
public class ProcedimientoMedicoController {

    @Autowired
    private ProcedimientoMedicoService procedimientoService;
    
    @PostMapping
    public ResponseEntity<ProcedimientoMedicoEntity> registrarProcedimiento(@RequestBody ProcedimientoMedicoEntity procedimiento) {
        return ResponseEntity.ok(procedimientoService.registrarProcedimiento(procedimiento));
    }
    
    @GetMapping
    public ResponseEntity<List<ProcedimientoMedicoEntity>> listarProcedimientos(){
        return ResponseEntity.ok(procedimientoService.listarProcedimientos());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProcedimientoMedicoEntity> actualizarProcedimiento(@PathVariable("id") Integer id, @RequestBody ProcedimientoMedicoEntity procedimiento) {
        procedimiento.setIdProcedimiento(id);
        return ResponseEntity.ok(procedimientoService.actualizarProcedimiento(procedimiento));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProcedimiento(@PathVariable("id") Integer id) {
        procedimientoService.eliminarProcedimiento(id);
        return ResponseEntity.ok("Procedimiento médico eliminado con éxito");
    }
}

