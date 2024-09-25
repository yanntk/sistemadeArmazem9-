package br.ufpb.dcx.yan.sistema.model;

public class Produto {
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome='" + nome + '\'' + ", preco=" + preco + ", categoria=" + categoria + '}';
    }
}
