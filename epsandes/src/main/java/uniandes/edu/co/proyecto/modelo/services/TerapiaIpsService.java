package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.TerapiaEntity;
import uniandes.edu.co.epsandes.modelo.IpsEntity;
import uniandes.edu.co.epsandes.modelo.TerapiaIpsEntity;
import uniandes.edu.co.epsandes.repositories.TerapiaIpsRepository;

@Service
public class TerapiaIpsService {

    @Autowired
    private TerapiaIpsRepository terapiaIpsRepository;

   
    public TerapiaIpsEntity asignarTerapiaAips(TerapiaEntity terapia, IpsEntity ips) {
        TerapiaIpsEntity terapiaIps = new TerapiaIpsEntity(terapia, ips);
        return terapiaIpsRepository.save(terapiaIps);
    }
}

