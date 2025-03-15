package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoEntity;
import uniandes.edu.co.epsandes.repositories.ProcedimientoMedicoRepository;
import java.util.List;

@Service
public class ProcedimientoMedicoService {

    @Autowired
    private ProcedimientoMedicoRepository procedimientoRepository;

    
    public ProcedimientoMedicoEntity registrarProcedimiento(ProcedimientoMedicoEntity procedimiento) {
        return procedimientoRepository.save(procedimiento);
    }

    public ProcedimientoMedicoEntity actualizarProcedimiento(ProcedimientoMedicoEntity procedimiento) {
        if (procedimientoRepository.existsById(procedimiento.getIdProcedimiento())) {
            return procedimientoRepository.save(procedimiento);
        }
        throw new RuntimeException("Procedimiento no existe con id " + procedimiento.getIdProcedimiento());
    }

    public void eliminarProcedimiento(Integer idProcedimiento) {
        procedimientoRepository.deleteById(idProcedimiento);
    }

    public List<ProcedimientoMedicoEntity> listarProcedimientos() {
        return procedimientoRepository.findAll();
    }
}

