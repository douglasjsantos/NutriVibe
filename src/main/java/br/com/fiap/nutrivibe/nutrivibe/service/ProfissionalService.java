package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional gravar(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }


    public Profissional buscarPorId(Long id) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(id);

        if (profissionalOptional.isPresent()) {
            return profissionalOptional.get();
        } else {
            throw new RuntimeException("Profissional não encontrado");
        }
    }

    public List<Profissional> listarTodosOsProfissionais() {
        return profissionalRepository.findAll();
    }


    public Profissional Atualizar(Profissional profissional) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(profissional.getId());

        if (profissionalOptional.isPresent()) {
            return profissionalRepository.save(profissionalOptional.get());
        } else {
            throw new RuntimeException("Profissional não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(id);

        if (profissionalOptional.isPresent()) {
            profissionalRepository.delete(profissionalOptional.get());
        } else {
            throw new RuntimeException("Profissional não localizado");
        }
    }


}
