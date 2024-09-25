package br.ufpb.dcx.yan.sistema.test;

import br.ufpb.dcx.yan.sistema.controller.SistemaEstoqueMap;
import br.ufpb.dcx.yan.sistema.model.Categoria;
import br.ufpb.dcx.yan.sistema.model.ProdutoInexistenteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SistemaEstoqueMapTest {

    @Test
    public void testeAdicionarProduto() {
        SistemaEstoqueMap estoque = new SistemaEstoqueMap();
        Categoria categoria = new Categoria("Roupas");
        estoque.adicionarProduto("Camiseta", 29.90, categoria);
        assertDoesNotThrow(() -> estoque.buscarProduto("Camiseta"));
    }

    @Test
    public void testeRemoverProduto() throws ProdutoInexistenteException {
        SistemaEstoqueMap estoque = new SistemaEstoqueMap();
        Categoria categoria = new Categoria("Roupas");
        estoque.adicionarProduto("Camiseta", 29.90, categoria);
        estoque.removerProduto("Camiseta");
        assertThrows(ProdutoInexistenteException.class, () -> estoque.buscarProduto("Camiseta"));
    }
}
