package br.ufpb.dcx.yan.sistema.controller;

import br.ufpb.dcx.yan.sistema.model.Produto;

import java.util.List;

public interface SistemaEstoqueFacade {
    void adicionarProduto(Produto produto);  // Aceita um objeto Produto diretamente
    void removerProduto(String nome);
    Produto buscarProduto(String nome);
    List<Produto> listarProdutos();
}