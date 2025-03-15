package uniandes.edu.co.epsandes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.epsandes.modelo.AfiliadoEntity;
import uniandes.edu.co.epsandes.repositories.AfiliadoRepository;
import java.util.List;

@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    
    public AfiliadoEntity registrarAfiliado(AfiliadoEntity afiliado) {
        return afiliadoRepository.save(afiliado);
    }

    public AfiliadoEntity actualizarAfiliado(AfiliadoEntity afiliado) {
        if (afiliadoRepository.existsById(afiliado.getIdAfiliado())) {
            return afiliadoRepository.save(afiliado);
        }
        throw new RuntimeException("Afiliado no existe con id " + afiliado.getIdAfiliado());
    }

    public void eliminarAfiliado(Integer idAfiliado) {
        afiliadoRepository.deleteById(idAfiliado);
    }

    public List<AfiliadoEntity> listarAfiliados() {
        return afiliadoRepository.findAll();
    }
}

