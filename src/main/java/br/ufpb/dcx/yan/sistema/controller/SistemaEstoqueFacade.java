package br.ufpb.dcx.yan.sistema.controller;

import br.ufpb.dcx.yan.sistema.model.Produto;
import br.ufpb.dcx.yan.sistema.model.Categoria;
import br.ufpb.dcx.yan.sistema.model.ProdutoInexistenteException;

import java.util.List;

public interface SistemaEstoqueFacade {
    void adicionarProduto(String nome, double preco, Categoria categoria);
    void removerProduto(String nome) throws ProdutoInexistenteException;
    Produto buscarProduto(String nome) throws ProdutoInexistenteException;
    List<Produto> listarProdutos();
}
