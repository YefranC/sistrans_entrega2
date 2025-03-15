package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.HospitalizacionEntity;
import uniandes.edu.co.epsandes.repositories.HospitalizacionRepository;
import java.util.List;

@Service
public class HospitalizacionService {

    @Autowired
    private HospitalizacionRepository hospitalizacionRepository;

    
    public HospitalizacionEntity registrarHospitalizacion(HospitalizacionEntity hospitalizacion) {
        return hospitalizacionRepository.save(hospitalizacion);
    }

    public HospitalizacionEntity actualizarHospitalizacion(HospitalizacionEntity hospitalizacion) {
        if (hospitalizacionRepository.existsById(hospitalizacion.getIdHospitalizacion())) {
            return hospitalizacionRepository.save(hospitalizacion);
        }
        throw new RuntimeException("Hospitalización no existe con id " + hospitalizacion.getIdHospitalizacion());
    }

    public void eliminarHospitalizacion(Integer idHospitalizacion) {
        hospitalizacionRepository.deleteById(idHospitalizacion);
    }

    public List<HospitalizacionEntity> listarHospitalizaciones() {
        return hospitalizacionRepository.findAll();
    }
}
