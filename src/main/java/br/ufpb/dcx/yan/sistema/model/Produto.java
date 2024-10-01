package br.ufpb.dcx.yan.sistema.model;

import java.util.ArrayList;

public class Produto {
    private static ArrayList<Produto> produto;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public static ArrayList<Produto> getProduto() {
        return produto;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

