package br.ufpb.dcx.yan.sistema.gui;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema de Estoque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando um JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Criando um JMenu
        JMenu menuArquivo = new JMenu("Arquivo");
        menuBar.add(menuArquivo);

        // Adicionando itens no menu
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
        menuArquivo.add(itemSair);

        // Configurando o JMenuBar no JFrame
        setJMenuBar(menuBar);

        // Layout básico
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo ao Sistema de Estoque", SwingConstants.CENTER);
        container.add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setVisible(true);
    }
}
