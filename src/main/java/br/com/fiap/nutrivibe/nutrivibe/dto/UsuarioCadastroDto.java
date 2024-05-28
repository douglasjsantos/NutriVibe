package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioCadastroDto (
    @NotBlank(message = "O Nome do usuario é obrigatório!")
    String nome,

    @NotBlank(message = "O e-mail é obrigatório!")
    @Email(message = "O e-amil está com formato inválido!")
    String email,

    @NotBlank(message = "A senha é obrigatória!")
    @Size(min = 6,max = 10, message = "A senha deve conter entre 6 e 10 caracteres!")
    String senha,

    @NotBlank(message = "O CPF é obrigatóri0!")
    @CPF(message = "O CPF esta em um formato inválido!")
    String cpf,

    @NotNull(message = "A data de nascimento é obrigatória!")
    LocalDate dataNascimento,

    @NotNull(message = "Regra de anesso necessária campo! exemplo 'role':'admin'")
    UsuarioRole role


){}
