package br.com.contasfacil.serverapi.security;

import br.com.socialfood.dominio.service.usuario.CriptografiaDeStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/*
* Service para iniciar um novo processo de autenticação
* */

@Service
public class AuthenticationService {

    @Value("${security.header.prefix}")
    private String headerPrefix;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    public String authenticate(String email, String senha) {
        //criptografar senha
        try {
            senha = CriptografiaDeStringService.criptografar(senha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                email,
                senha
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return headerPrefix + tokenProvider.generateToken(authentication);
    }

}
