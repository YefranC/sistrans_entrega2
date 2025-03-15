package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.AfiliadoEntity;
import uniandes.edu.co.epsandes.services.AfiliadoService;
import java.util.List;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;
    
    @PostMapping
    public ResponseEntity<AfiliadoEntity> registrarAfiliado(@RequestBody AfiliadoEntity afiliado) {
        AfiliadoEntity nuevo = afiliadoService.registrarAfiliado(afiliado);
        return ResponseEntity.ok(nuevo);
    }
    
    @GetMapping
    public ResponseEntity<List<AfiliadoEntity>> listarAfiliados(){
        return ResponseEntity.ok(afiliadoService.listarAfiliados());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AfiliadoEntity> actualizarAfiliado(@PathVariable("id") Integer id, @RequestBody AfiliadoEntity afiliado) {
        afiliado.setIdAfiliado(id);
        return ResponseEntity.ok(afiliadoService.actualizarAfiliado(afiliado));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAfiliado(@PathVariable("id") Integer id) {
        afiliadoService.eliminarAfiliado(id);
        return ResponseEntity.ok("Afiliado eliminado con éxito");
    }
}
