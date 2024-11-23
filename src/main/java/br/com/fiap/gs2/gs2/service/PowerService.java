package br.com.fiap.gs2.gs2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.gs2.gs2.model.Power;
import br.com.fiap.gs2.gs2.repository.PowerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PowerService {
    private final PowerRepository powerRepository = null;

    public List<Power> list() {
        return powerRepository.findAll();
    }

    public Power save(Power power) {        
        return powerRepository.save(power);
    }

    public boolean existsById(Long id) {        
        return powerRepository.existsById(id);
    }

    public void delete(Long id) {
        powerRepository.deleteById(id);
    }

    public Optional<Power> findById(Long id) {
        return powerRepository.findById(id);
    }
   
}
