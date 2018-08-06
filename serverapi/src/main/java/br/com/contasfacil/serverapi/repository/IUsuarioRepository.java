package br.com.contasfacil.serverapi.repository;

import br.com.contasfacil.serverapi.entity.Usuario;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IUsuarioRepository extends Repository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    void save(Usuario usuario);

    Optional<Usuario> findById(Long id);
}
