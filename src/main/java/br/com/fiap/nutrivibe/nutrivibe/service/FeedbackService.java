package br.com.fiap.nutrivibe.nutrivibe.service;


import br.com.fiap.nutrivibe.nutrivibe.model.Feedback;
import br.com.fiap.nutrivibe.nutrivibe.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback gravar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback buscarPorId(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);

        if (feedbackOptional.isPresent()) {
            return feedbackOptional.get();
        } else {
            throw new RuntimeException("Feedback não encontrado");
        }
    }

    public List<Feedback> listarTodosOsFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback Atualizar(Feedback feedback) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(feedback.getId());

        if (feedbackOptional.isPresent()) {
            return feedbackRepository.save(feedbackOptional.get());
        } else {
            throw new RuntimeException("Feedback não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);

        if (feedbackOptional.isPresent()) {
            feedbackRepository.delete(feedbackOptional.get());
        } else {
            throw new RuntimeException("Feedback não localizado");
        }
    }

}
