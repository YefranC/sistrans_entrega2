package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.ExamenDiagnosticoEntity;
import uniandes.edu.co.epsandes.modelo.IpsEntity;
import uniandes.edu.co.epsandes.modelo.ExamenIpsEntity;
import uniandes.edu.co.epsandes.repositories.ExamenIpsRepository;

@Service
public class ExamenIpsService {

    @Autowired
    private ExamenIpsRepository examenIpsRepository;

    
    public ExamenIpsEntity asignarExamenAips(ExamenDiagnosticoEntity examen, IpsEntity ips) {
        ExamenIpsEntity examenIps = new ExamenIpsEntity(examen, ips);
        return examenIpsRepository.save(examenIps);
    }
}

