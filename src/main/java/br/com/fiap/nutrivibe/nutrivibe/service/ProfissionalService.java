package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.repository.ProfissionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProfissionalExibitionDto gravar(ProfissionalCadastroDto profissionalCadastroDto) {
        Profissional profissional = new Profissional();
        BeanUtils.copyProperties(profissionalCadastroDto, profissional);

        return new ProfissionalExibitionDto(profissionalRepository.save(profissional));
    }


    public ProfissionalExibitionDto buscarPorId(Long id) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(id);

        if (profissionalOptional.isPresent()) {
            return new ProfissionalExibitionDto(profissionalOptional.get());
        } else {
            throw new RuntimeException("Profissional não encontrado");
        }
    }

    public Page<ProfissionalExibitionDto> listarTodosOsProfissionais(Pageable paginacao) {
        Page<ProfissionalExibitionDto> profissional = profissionalRepository
                .findAll(paginacao)
                .map(ProfissionalExibitionDto::new);
        return profissional;
    }


    public ProfissionalExibitionDto Atualizar(ProfissionalAtualizacaoDto profissionalAtualizacaoDto) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(profissionalAtualizacaoDto.id());

        if (profissionalOptional.isPresent()) {
            return new ProfissionalExibitionDto(profissionalRepository.save(profissionalOptional.get()));
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
