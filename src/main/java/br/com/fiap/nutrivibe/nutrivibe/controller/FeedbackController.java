package br.com.fiap.nutrivibe.nutrivibe.controller;


import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.FeedbackExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackExibitionDto gravar(@RequestBody @Valid FeedbackCadastroDto feedbackCadastroDto) {
        return service.gravar(feedbackCadastroDto);
    }

    @GetMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FeedbackExibitionDto buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/feedback")
    @ResponseStatus(HttpStatus.OK)
    public Page<FeedbackExibitionDto> listarTodosOsFeedbacks(Pageable pageable) {
        return service.listarTodosOsFeedbacks(pageable);
    }

    @PutMapping("/feedback")
    @ResponseStatus(HttpStatus.OK)
    public FeedbackExibitionDto atualizar(@RequestBody @Valid FeedbackAtualizacaoDto feedbackAtualizacaoDto) {
        return service.Atualizar(feedbackAtualizacaoDto);
    }

    @DeleteMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
