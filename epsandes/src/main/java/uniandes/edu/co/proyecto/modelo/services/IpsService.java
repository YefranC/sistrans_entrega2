package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.IpsEntity;
import uniandes.edu.co.epsandes.repositories.IpsRepository;
import java.util.List;

@Service
public class IpsService {

    @Autowired
    private IpsRepository ipsRepository;
    
    
    public IpsEntity registrarIps(IpsEntity ips) {
        return ipsRepository.save(ips);
    }
    
    
    public IpsEntity actualizarIps(IpsEntity ips) {
        if (ipsRepository.existsById(ips.getNit())) {
            return ipsRepository.save(ips);
        }
        throw new RuntimeException("IPS no existe con nit " + ips.getNit());
    }
    
    
    public void eliminarIps(Integer nit) {
        ipsRepository.deleteById(nit);
    }
    
    
    public List<IpsEntity> listarIps() {
        return ipsRepository.findAll();
    }
}

