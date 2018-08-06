package br.com.contasfacil.serverapi.exception;

public class UsuarioIncorretoException extends RuntimeException {
    public UsuarioIncorretoException(){
        super("Usuario incorreto");
    }
}
