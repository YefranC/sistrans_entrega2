package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.TerapiaEntity;
import uniandes.edu.co.epsandes.services.TerapiaService;
import java.util.List;

@RestController
@RequestMapping("/terapias")
public class TerapiaController {

    @Autowired
    private TerapiaService terapiaService;
    
    @PostMapping
    public ResponseEntity<TerapiaEntity> registrarTerapia(@RequestBody TerapiaEntity terapia) {
        return ResponseEntity.ok(terapiaService.registrarTerapia(terapia));
    }
    
    @GetMapping
    public ResponseEntity<List<TerapiaEntity>> listarTerapias(){
        return ResponseEntity.ok(terapiaService.listarTerapias());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TerapiaEntity> actualizarTerapia(@PathVariable("id") Integer id, @RequestBody TerapiaEntity terapia) {
        terapia.setIdTerapia(id);
        return ResponseEntity.ok(terapiaService.actualizarTerapia(terapia));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTerapia(@PathVariable("id") Integer id) {
        terapiaService.eliminarTerapia(id);
        return ResponseEntity.ok("Terapia eliminada con éxito");
    }
}

