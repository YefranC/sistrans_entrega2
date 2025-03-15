package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoIpsEntity;
import uniandes.edu.co.epsandes.services.ProcedimientoMedicoIpsService;

@RestController
@RequestMapping("/procedimientoips")
public class ProcedimientoMedicoIpsController {

    @Autowired
    private ProcedimientoMedicoIpsService procedimientoIpsService;
    
    @PostMapping
    public ResponseEntity<ProcedimientoMedicoIpsEntity> asignarProcedimientoAips(@RequestParam Integer idProcedimiento,
                                                                                  @RequestParam Integer nit) {
        ProcedimientoMedicoIpsEntity asignacion = procedimientoIpsService.asignarProcedimientoAips(
                new uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoEntity(idProcedimiento), 
                new uniandes.edu.co.epsandes.modelo.IpsEntity(nit)
        );
        return ResponseEntity.ok(asignacion);
    }
}

