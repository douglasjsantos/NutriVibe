package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoAtualizaçãoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.execption.ObjetoNaoEncontradoException;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.repository.ProfissionalRepository;
import br.com.fiap.nutrivibe.nutrivibe.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ServicoExibitionDto gravar(ServicoCadastroDto servicoCadastroDto) {

        Optional<Profissional> profissional = profissionalRepository.findById(servicoCadastroDto.profissional_id());

        if (profissional.isPresent()) {
            Servico servico = new Servico();
            BeanUtils.copyProperties(servicoCadastroDto, servico);
            servico.setProfissional(profissional.get());
            return new ServicoExibitionDto(servicoRepository.save(servico));
        } else {
            throw new ObjetoNaoEncontradoException("Profissional não encontrado");
        }


    }

    public ServicoExibitionDto buscarPorId(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);

        if (servicoOptional.isPresent()) {
            return new ServicoExibitionDto(servicoOptional.get());
        } else {
            throw new ObjetoNaoEncontradoException("Serviço não encontrado");
        }
    }

    public Page<ServicoExibitionDto> listarTodosOsServicos(Pageable paginacao) {
        Page<ServicoExibitionDto> servicos = servicoRepository
                .findAll(paginacao)
                .map(ServicoExibitionDto::new);
        return servicos;
    }

    public ServicoExibitionDto Atualizar(ServicoAtualizaçãoDto servicoAtualizaçãoDto) {
        Optional<Servico> servicoptional = servicoRepository.findById(servicoAtualizaçãoDto.id());

        if (servicoptional.isPresent()) {
            Optional<Profissional> profissional = profissionalRepository.findById(servicoAtualizaçãoDto.profissional_id());

            if (profissional.isPresent()) {
                Servico servico = new Servico();
                BeanUtils.copyProperties(servicoAtualizaçãoDto, servico);
                servico.setProfissional(profissional.get());
                return new ServicoExibitionDto(servicoRepository.save(servico));
            } else {
                throw new ObjetoNaoEncontradoException("Profissional não encontrado");
            }
        } else {
            throw new ObjetoNaoEncontradoException("Serviço não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);

        if (servicoOptional.isPresent()) {
            servicoRepository.delete(servicoOptional.get());
        } else {
            throw new ObjetoNaoEncontradoException("Serviço não localizado");
        }
    }


}
