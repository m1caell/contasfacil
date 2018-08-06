package br.com.contasfacil.serverapi.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioRegistroRequestDto {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
}
