package br.ufpb.dcx.yan.sistema.controller;


import br.ufpb.dcx.yan.sistema.model.Produto;
import br.ufpb.dcx.yan.sistema.model.Categoria;
import br.ufpb.dcx.yan.sistema.model.ProdutoInexistenteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEstoqueMap implements SistemaEstoqueFacade {
    private Map<String, Produto> produtos;

    public SistemaEstoqueMap() {
        this.produtos = new HashMap<>();
    }

    @Override
    public void adicionarProduto(String nome, double preco, Categoria categoria) {
        Produto produto = new Produto(nome, preco, categoria);
        produtos.put(nome, produto);
    }

    @Override
    public void removerProduto(String nome) throws ProdutoInexistenteException {
        if (!produtos.containsKey(nome)) {
            throw new ProdutoInexistenteException("Produto " + nome + " não encontrado.");
        }
        produtos.remove(nome);
    }

    @Override
    public Produto buscarProduto(String nome) throws ProdutoInexistenteException {
        if (!produtos.containsKey(nome)) {
            throw new ProdutoInexistenteException("Produto " + nome + " não encontrado.");
        }
        return produtos.get(nome);
    }

    @Override
    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos.values());
    }
}
