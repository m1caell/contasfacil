package br.com.contasfacil.serverapi.models.request;


import lombok.Data;

@Data
public class UsuarioLoginRequestDto {
    private String email;
    private String senha;
}
