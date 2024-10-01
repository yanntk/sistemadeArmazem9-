package br.ufpb.dcx.yan.sistema.test;

import br.ufpb.dcx.yan.sistema.model.Produto;
import br.ufpb.dcx.yan.sistema.model.Categoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testeCriacaoProduto() {
        Categoria categoria = new Categoria("Roupas");
        Produto produto = new Produto("Camiseta", 29.90, categoria);
        assertEquals("Camiseta", produto.getNome());
        assertEquals(29.90, produto.getPreco());
        assertEquals(categoria, produto.getCategoria());
    }
}
