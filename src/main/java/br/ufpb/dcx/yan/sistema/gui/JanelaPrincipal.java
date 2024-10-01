
package br.ufpb.dcx.yan.sistema.gui;

import br.ufpb.dcx.yan.sistema.controller.SistemaEstoqueFacade;
import br.ufpb.dcx.yan.sistema.controller.SistemaEstoqueMap;
import br.ufpb.dcx.yan.sistema.model.Produto;
import br.ufpb.dcx.yan.sistema.model.Categoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaPrincipal extends JFrame {
    private SistemaEstoqueFacade sistemaEstoque;

    private JTextField nomeField;
    private JTextField precoField;
    private JTextField categoriaField;

    public JanelaPrincipal(SistemaEstoqueFacade sistemaEstoque) {
        this.sistemaEstoque = sistemaEstoque;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Estoque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel painelCadastro = new JPanel(new GridLayout(4, 2));

        // Campos de texto e rótulos
        painelCadastro.add(new JLabel("Nome do Produto:"));
        nomeField = new JTextField();
        painelCadastro.add(nomeField);

        painelCadastro.add(new JLabel("Preço:"));
        precoField = new JTextField();
        painelCadastro.add(precoField);

        painelCadastro.add(new JLabel("Categoria:"));
        categoriaField = new JTextField();
        painelCadastro.add(categoriaField);

        // Botão para adicionar produto
        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });
        painelCadastro.add(adicionarButton);

        // Botão para listar produtos
        JButton listarButton = new JButton("Listar Produtos");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });
        painelCadastro.add(listarButton);

        // Adiciona o painel à janela
        add(painelCadastro, BorderLayout.CENTER);
    }

    private void adicionarProduto() {
        try {
            String nome = nomeField.getText();
            double preco = Double.parseDouble(precoField.getText());
            String categoriaNome = categoriaField.getText();

            Categoria categoria = new Categoria(categoriaNome); // Criando um objeto Categoria
            Produto produto = new Produto(nome, preco, categoria);
            sistemaEstoque.adicionarProduto(produto);

            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar campos após adicionar
            nomeField.setText("");
            precoField.setText("");
            categoriaField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar o produto. O preço deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar o produto. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarProdutos() {
        StringBuilder lista = new StringBuilder("Listando produtos:\n\n");
        List<Produto> produtos = sistemaEstoque.listarProdutos();

        if (produtos.isEmpty()) {
            lista.append("Nenhum produto para exibir.");
        } else {
            for (Produto p : produtos) {
                lista.append("Nome: ").append(p.getNome())
                        .append(", Preço: ").append(p.getPreco())
                        .append(", Categoria: ").append(p.getCategoria().getNomeCategoria())
                        .append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, lista.toString(), "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SistemaEstoqueFacade sistemaEstoque = new SistemaEstoqueMap();  // Substitua com sua implementação
        JanelaPrincipal janela = new JanelaPrincipal(sistemaEstoque);
        janela.setVisible(true);
    }
}
