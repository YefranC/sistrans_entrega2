package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.ExamenDiagnosticoEntity;
import uniandes.edu.co.epsandes.repositories.ExamenDiagnosticoRepository;
import java.util.List;

@Service
public class ExamenDiagnosticoService {

    @Autowired
    private ExamenDiagnosticoRepository examenRepository;

    
    public ExamenDiagnosticoEntity registrarExamen(ExamenDiagnosticoEntity examen) {
        return examenRepository.save(examen);
    }

    public ExamenDiagnosticoEntity actualizarExamen(ExamenDiagnosticoEntity examen) {
        if (examenRepository.existsById(examen.getIdExamen())) {
            return examenRepository.save(examen);
        }
        throw new RuntimeException("Examen no existe con id " + examen.getIdExamen());
    }

    public void eliminarExamen(Integer idExamen) {
        examenRepository.deleteById(idExamen);
    }

    public List<ExamenDiagnosticoEntity> listarExamenes() {
        return examenRepository.findAll();
    }
}

