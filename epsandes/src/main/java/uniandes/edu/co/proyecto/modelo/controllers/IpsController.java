package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.IpsEntity;
import uniandes.edu.co.epsandes.services.IpsService;
import java.util.List;

@RestController
@RequestMapping("/ips")
public class IpsController {

    @Autowired
    private IpsService ipsService;
    
    @PostMapping
    public ResponseEntity<IpsEntity> registrarIps(@RequestBody IpsEntity ips) {
        return ResponseEntity.ok(ipsService.registrarIps(ips));
    }
    
    @GetMapping
    public ResponseEntity<List<IpsEntity>> listarIps(){
        return ResponseEntity.ok(ipsService.listarIps());
    }
    
    @PutMapping("/{nit}")
    public ResponseEntity<IpsEntity> actualizarIps(@PathVariable("nit") Integer nit, @RequestBody IpsEntity ips) {
        ips.setNit(nit);
        return ResponseEntity.ok(ipsService.actualizarIps(ips));
    }
    
    @DeleteMapping("/{nit}")
    public ResponseEntity<String> eliminarIps(@PathVariable("nit") Integer nit) {
        ipsService.eliminarIps(nit);
        return ResponseEntity.ok("IPS eliminada con éxito");
    }
}
