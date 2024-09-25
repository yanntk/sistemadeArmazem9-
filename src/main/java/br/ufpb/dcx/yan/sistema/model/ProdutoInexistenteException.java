package br.ufpb.dcx.yan.sistema.model;

public class ProdutoInexistenteException extends Exception {
    public ProdutoInexistenteException(String message) {
        super(message);
    }
}
