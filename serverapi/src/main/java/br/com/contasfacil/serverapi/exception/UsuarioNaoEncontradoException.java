package br.com.contasfacil.serverapi.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(){
        super("Usuario não encontrado!");
    }
}
