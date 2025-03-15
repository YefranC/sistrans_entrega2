package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.TerapiaIpsEntity;
import uniandes.edu.co.epsandes.services.TerapiaIpsService;

@RestController
@RequestMapping("/terapiaips")
public class TerapiaIpsController {

    @Autowired
    private TerapiaIpsService terapiaIpsService;
    
    @PostMapping
    public ResponseEntity<TerapiaIpsEntity> asignarTerapiaAips(@RequestParam Integer idTerapia,
                                                               @RequestParam Integer nit) {
        TerapiaIpsEntity asignacion = terapiaIpsService.asignarTerapiaAips(
                new uniandes.edu.co.epsandes.modelo.TerapiaEntity(idTerapia), 
                new uniandes.edu.co.epsandes.modelo.IpsEntity(nit)
        );
        return ResponseEntity.ok(asignacion);
    }
}

