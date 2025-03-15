package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.OrdenServicioEntity;
import uniandes.edu.co.epsandes.repositories.OrdenServicioRepository;
import java.util.List;

@Service
public class OrdenServicioService {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    
    public OrdenServicioEntity registrarOrdenServicio(OrdenServicioEntity orden) {
        return ordenServicioRepository.save(orden);
    }

    public OrdenServicioEntity actualizarOrdenServicio(OrdenServicioEntity orden) {
        if (ordenServicioRepository.existsById(orden.getIdOrden())) {
            return ordenServicioRepository.save(orden);
        }
        throw new RuntimeException("Orden de servicio no existe con id " + orden.getIdOrden());
    }

    public void eliminarOrdenServicio(Integer idOrden) {
        ordenServicioRepository.deleteById(idOrden);
    }

    public List<OrdenServicioEntity> listarOrdenServicios() {
        return ordenServicioRepository.findAll();
    }
}

