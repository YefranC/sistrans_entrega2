package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.MedicoEntity;
import uniandes.edu.co.epsandes.repositories.MedicoRepository;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    
    public MedicoEntity registrarMedico(MedicoEntity medico) {
        return medicoRepository.save(medico);
    }

    public MedicoEntity actualizarMedico(MedicoEntity medico) {
        if (medicoRepository.existsById(medico.getIdMedico())) {
            return medicoRepository.save(medico);
        }
        throw new RuntimeException("Médico no existe con id " + medico.getIdMedico());
    }

    public void eliminarMedico(Integer idMedico) {
        medicoRepository.deleteById(idMedico);
    }

    public List<MedicoEntity> listarMedicos() {
        return medicoRepository.findAll();
    }
}

