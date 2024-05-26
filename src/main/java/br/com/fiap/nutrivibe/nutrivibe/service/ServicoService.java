package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico gravar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico buscarPorId(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);

        if (servicoOptional.isPresent()) {
            return servicoOptional.get();
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public List<Servico> listarTodosOsServicos() {
        return servicoRepository.findAll();
    }

    public Servico Atualizar(Servico servico) {
        Optional<Servico> servicoptional = servicoRepository.findById(servico.getId());

        if (servicoptional.isPresent()) {
            return servicoRepository.save(servicoptional.get());
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);

        if (servicoOptional.isPresent()) {
            servicoRepository.delete(servicoOptional.get());
        } else {
            throw new RuntimeException("Serviço não localizado");
        }
    }


}
