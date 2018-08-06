package br.com.contasfacil.serverapi.service;

import br.com.contasfacil.serverapi.entity.Usuario;
import br.com.contasfacil.serverapi.exception.DadosDeEntradaInvalidoException;
import br.com.contasfacil.serverapi.exception.UsuarioIncorretoException;
import br.com.contasfacil.serverapi.models.response.UsuarioLoginResponseDto;
import br.com.contasfacil.serverapi.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;


    public UsuarioLoginResponseDto logar(String email, String senha) {
        if(email.isEmpty() || senha.isEmpty()) {
            throw new DadosDeEntradaInvalidoException();
        }

        String token = authenticationService.authenticate(email, senha);

        if(token.isEmpty()) {
            throw new UsuarioIncorretoException();
        }

        Usuario usuario = usuarioAutenticadoService.getUsuarioLogado();

        return new UsuarioLoginResponseDto(usuario.getId(),usuario.getNome(),usuario.getEmail(), token);
    }


}
