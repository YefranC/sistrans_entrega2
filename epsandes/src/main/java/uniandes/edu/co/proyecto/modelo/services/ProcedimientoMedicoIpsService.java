package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoEntity;
import uniandes.edu.co.epsandes.modelo.IpsEntity;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoIpsEntity;
import uniandes.edu.co.epsandes.repositories.ProcedimientoMedicoIpsRepository;

@Service
public class ProcedimientoMedicoIpsService {

    @Autowired
    private ProcedimientoMedicoIpsRepository procedimientoIpsRepository;

    
    public ProcedimientoMedicoIpsEntity asignarProcedimientoAips(ProcedimientoMedicoEntity procedimiento, IpsEntity ips) {
        ProcedimientoMedicoIpsEntity procedimientoIps = new ProcedimientoMedicoIpsEntity(procedimiento, ips);
        return procedimientoIpsRepository.save(procedimientoIps);
    }
}

