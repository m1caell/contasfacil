package br.com.contasfacil.serverapi.service;

import br.com.contasfacil.serverapi.entity.Usuario;
import br.com.contasfacil.serverapi.exception.UsuarioNaoEncontradoException;
import br.com.contasfacil.serverapi.repository.IUsuarioRepository;
import br.com.contasfacil.serverapi.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAutenticadoService {

    @Autowired
    private IUsuarioRepository repository;

    public Usuario getUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal usuarioAtual = (UserPrincipal) authentication.getPrincipal();

        Usuario usuario = repository.findById(usuarioAtual.getId()).orElseThrow(
                () -> new UsuarioNaoEncontradoException()
        );

        return usuario;
    }

}
