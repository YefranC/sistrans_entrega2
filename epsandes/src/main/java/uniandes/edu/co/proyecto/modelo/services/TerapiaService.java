package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.TerapiaEntity;
import uniandes.edu.co.epsandes.repositories.TerapiaRepository;
import java.util.List;

@Service
public class TerapiaService {

    @Autowired
    private TerapiaRepository terapiaRepository;

    
    public TerapiaEntity registrarTerapia(TerapiaEntity terapia) {
        return terapiaRepository.save(terapia);
    }

    public TerapiaEntity actualizarTerapia(TerapiaEntity terapia) {
        if (terapiaRepository.existsById(terapia.getIdTerapia())) {
            return terapiaRepository.save(terapia);
        }
        throw new RuntimeException("Terapia no existe con id " + terapia.getIdTerapia());
    }

    public void eliminarTerapia(Integer idTerapia) {
        terapiaRepository.deleteById(idTerapia);
    }

    public List<TerapiaEntity> listarTerapias() {
        return terapiaRepository.findAll();
    }
}

