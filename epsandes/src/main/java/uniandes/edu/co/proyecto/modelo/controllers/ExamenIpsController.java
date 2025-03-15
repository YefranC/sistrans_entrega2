package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.ExamenIpsEntity;
import uniandes.edu.co.epsandes.services.ExamenIpsService;

@RestController
@RequestMapping("/examenips")
public class ExamenIpsController {

    @Autowired
    private ExamenIpsService examenIpsService;
    
    @PostMapping
    public ResponseEntity<ExamenIpsEntity> asignarExamenAips(@RequestParam Integer idExamen,
                                                             @RequestParam Integer nit) {
        ExamenIpsEntity asignacion = examenIpsService.asignarExamenAips(
                new uniandes.edu.co.epsandes.modelo.ExamenDiagnosticoEntity(idExamen), 
                new uniandes.edu.co.epsandes.modelo.IpsEntity(nit)
        );
        return ResponseEntity.ok(asignacion);
    }
}
