package uniandes.edu.co.epsandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.services.AgendaService;
import java.util.Date;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;
    
    @GetMapping("/disponibilidad")
    public ResponseEntity<String> consultarDisponibilidad(@RequestParam String codigoServicio) {
        String respuesta = agendaService.consultarDisponibilidad(codigoServicio);
        return ResponseEntity.ok(respuesta);
    }
    
    @PostMapping("/agendar")
    public ResponseEntity<String> agendarServicio(@RequestParam Integer idOrden,
                                                   @RequestParam Date fechaAgendada) {
        String respuesta = agendaService.agendarServicio(idOrden, fechaAgendada);
        return ResponseEntity.ok(respuesta);
    }
}

