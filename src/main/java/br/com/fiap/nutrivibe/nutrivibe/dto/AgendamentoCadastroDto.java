package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgendamentoCadastroDto (
        @NotBlank(message = "A dataHora é obrigatória!")
        LocalDateTime dataHora,
        @NotBlank(message = "O ID do usuario é obrigatório!")
        Long usuario_id,
        @NotBlank(message = "O ID do serviço é obrigatório!")
        Long servico_id
){
}
