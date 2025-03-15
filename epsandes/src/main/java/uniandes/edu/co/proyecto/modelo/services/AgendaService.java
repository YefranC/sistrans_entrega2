package uniandes.edu.co.epsandes.services;

import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AgendaService {

    
    public String consultarDisponibilidad(String codigoServicio) {
        return "Disponibilidad consultada para el servicio: " + codigoServicio;
    }

    
    public String agendarServicio(Integer idOrden, Date fechaAgendada) {
        return "Servicio agendado para la orden " + idOrden + " en la fecha " + fechaAgendada;
    }
}

