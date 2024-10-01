package br.ufpb.dcx.yan.sistema.controller;

import br.ufpb.dcx.yan.sistema.model.Produto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SistemaEstoqueMap implements SistemaEstoqueFacade {
    private Map<String, Produto> estoque = new HashMap<>();

    @Override
    public void adicionarProduto(Produto produto) {
        estoque.put(produto.getNome(), produto);
    }

    @Override
    public void removerProduto(String nome) {
        estoque.remove(nome);
    }

    @Override
    public Produto buscarProduto(String nome) {
        return estoque.get(nome);
    }

    @Override
    public List<Produto> listarProdutos() {
        return new ArrayList<>(estoque.values());
    }
}

