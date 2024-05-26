package br.com.fiap.nutrivibe.nutrivibe.controller;


import br.com.fiap.nutrivibe.nutrivibe.model.Feedback;
import br.com.fiap.nutrivibe.nutrivibe.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback gravar(@RequestBody Feedback feedback) {
        return service.gravar(feedback);
    }

    @GetMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Feedback buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/feedback")
    @ResponseStatus(HttpStatus.OK)
    public List<Feedback> listarTodosOsFeedbacks() {
        return service.listarTodosOsFeedbacks();
    }

    @PutMapping("/feedback")
    @ResponseStatus(HttpStatus.OK)
    public Feedback atualizar(@RequestBody Feedback feedback) {
        return service.Atualizar(feedback);
    }

    @DeleteMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
