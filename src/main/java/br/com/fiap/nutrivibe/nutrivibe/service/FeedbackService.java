package br.com.fiap.nutrivibe.nutrivibe.service;


import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.execption.ObjetoNaoEncontradoException;
import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.model.Feedback;
import br.com.fiap.nutrivibe.nutrivibe.repository.AgendamentoRepository;
import br.com.fiap.nutrivibe.nutrivibe.repository.FeedbackRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public FeedbackExibitionDto gravar(FeedbackCadastroDto feedbackCadastroDto) {

        Optional<Agendamento> agendamento = agendamentoRepository.findById(feedbackCadastroDto.agendamento_id());

        if (agendamento.isPresent()) {
            Feedback feedback = new Feedback();
            BeanUtils.copyProperties(feedbackCadastroDto, feedback);
            feedback.setAgendamento(agendamento.get());

            return new FeedbackExibitionDto(feedbackRepository.save(feedback));
        } else {
            throw new ObjetoNaoEncontradoException("Agendamento não encontrado");
        }

    }

    public FeedbackExibitionDto buscarPorId(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);

        if (feedbackOptional.isPresent()) {
            return new FeedbackExibitionDto(feedbackOptional.get());
        } else {
            throw new ObjetoNaoEncontradoException("Feedback não encontrado");
        }
    }

    public Page<FeedbackExibitionDto> listarTodosOsFeedbacks(Pageable pageable) {
        Page<FeedbackExibitionDto> feedbacks = feedbackRepository
                .findAll(pageable)
                .map(FeedbackExibitionDto::new);
        return feedbacks;
    }

    public FeedbackExibitionDto Atualizar(FeedbackAtualizacaoDto feedbackAtualizacaoDto) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(feedbackAtualizacaoDto.id());

        if (feedbackOptional.isPresent()) {
            Optional<Agendamento> agendamento = agendamentoRepository.findById(feedbackAtualizacaoDto.agendamento_id());

            if (agendamento.isEmpty()) {
                Feedback feedback = new Feedback();
                BeanUtils.copyProperties(feedbackAtualizacaoDto, feedback);
                feedback.setAgendamento(agendamento.get());
                return new FeedbackExibitionDto(feedbackRepository.save(feedback));
            } else {
                throw new ObjetoNaoEncontradoException("Agendamento não encontrado");
            }
        } else {
            throw new ObjetoNaoEncontradoException("Feedback não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);

        if (feedbackOptional.isPresent()) {
            feedbackRepository.delete(feedbackOptional.get());
        } else {
            throw new ObjetoNaoEncontradoException("Feedback não localizado");
        }
    }

}
