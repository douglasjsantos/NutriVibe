package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.config.security.TokenService;
import br.com.fiap.nutrivibe.nutrivibe.dto.TokenDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioLoginDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto){
        UsernamePasswordAuthenticationToken usernamePassword=
                new UsernamePasswordAuthenticationToken(
                        usuarioLoginDto.email(),
                        usuarioLoginDto.senha()
                );
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibitionDto UsuarioExibitionDtoRegistrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        UsuarioExibitionDto usuarioSalvo = null;
        usuarioSalvo = usuarioService.gravar(usuarioCadastroDto);
        return usuarioSalvo;
    }
}
