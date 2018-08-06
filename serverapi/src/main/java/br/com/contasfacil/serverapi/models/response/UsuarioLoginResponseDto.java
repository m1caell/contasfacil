package br.com.contasfacil.serverapi.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioLoginResponseDto {

    private Long id;
    private String nome;
    private String email;
    private String token;
}
