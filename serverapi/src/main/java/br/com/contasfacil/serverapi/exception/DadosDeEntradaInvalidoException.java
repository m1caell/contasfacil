package br.com.contasfacil.serverapi.exception;

public class DadosDeEntradaInvalidoException extends RuntimeException {
    public DadosDeEntradaInvalidoException(){
        super("Dados de entrada inválidos");
    }
}
