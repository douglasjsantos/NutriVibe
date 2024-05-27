package br.com.fiap.nutrivibe.nutrivibe.service;


import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.repository.AgendamentoRepository;
import br.com.fiap.nutrivibe.nutrivibe.repository.ProfissionalRepository;
import br.com.fiap.nutrivibe.nutrivibe.repository.ServicoRepository;
import br.com.fiap.nutrivibe.nutrivibe.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public AgendamentoExibitionDto gravar(AgendamentoCadastroDto agendamentoCadastroDto) {

        Optional<Servico> servico = servicoRepository.findById(agendamentoCadastroDto.servico_id());
        Optional<Usuario> usuario = usuarioRepository.findById(agendamentoCadastroDto.usuario_id());

        if (servico.isPresent() && usuario.isPresent()) {
            Agendamento agendamento = new Agendamento();
            BeanUtils.copyProperties(agendamentoCadastroDto, agendamento);
            agendamento.setUsuario(usuario.get());
            agendamento.setServico(servico.get());
            return new AgendamentoExibitionDto(agendamentoRepository.save(agendamento));
        } else {
            StringBuilder mensagem = new StringBuilder();
            if (!usuario.isPresent()) {
                mensagem.append("Usuário não encontrado");
            }
            if (!servico.isPresent()) {
                mensagem.append("Serviço não encontrado");
            }
            throw new RuntimeException(String.valueOf(mensagem));
        }


    }

    public AgendamentoExibitionDto buscarPeloId(Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            return new AgendamentoExibitionDto(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public Page<AgendamentoExibitionDto> listarTodosOsAgendamentos(Pageable pageable) {
        Page<AgendamentoExibitionDto> agendamentos = agendamentoRepository
                .findAll(pageable)
                .map(AgendamentoExibitionDto::new);
        return agendamentos;
    }

    public AgendamentoExibitionDto Atualizar(AgendamentoAtualizacaoDto agendamentoAtualizacaoDto) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoAtualizacaoDto.id());

        if (agendamentoOptional.isPresent()) {

            Optional<Servico> servico = servicoRepository.findById(agendamentoAtualizacaoDto.servico_id());
            Optional<Usuario> usuario = usuarioRepository.findById(agendamentoAtualizacaoDto.usuario_id());

            if (servico.isPresent() && usuario.isPresent()) {
                Agendamento agendamento = new Agendamento();
                BeanUtils.copyProperties(agendamentoAtualizacaoDto, agendamento);
                agendamento.setUsuario(usuario.get());
                agendamento.setServico(servico.get());
                return new AgendamentoExibitionDto(agendamentoRepository.save(agendamento));
            } else {
                StringBuilder mensagem = new StringBuilder();
                if (!usuario.isPresent()) {
                    mensagem.append("Usuário não encontrado");
                }
                if (!servico.isPresent()) {
                    mensagem.append("Serviço não encontrado");
                }
                throw new RuntimeException(String.valueOf(mensagem));
            }
        } else {
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            agendamentoRepository.delete(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não localizado");
        }
    }

}
