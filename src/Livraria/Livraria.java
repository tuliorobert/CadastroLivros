package Livraria;

import javax.swing.JOptionPane;

public class Livraria {
    private String[] nome, autor, editora;
    private int ano[], qt;

    public void cadastrarLivros() {
        this.qt = Integer.parseInt(JOptionPane.showInputDialog("Quantos livros deseja cadastrar?"));

        this.nome = new String[qt];
        this.autor = new String[qt];
        this.editora = new String[qt];
        this.ano = new int[qt];

        for (int i = 0; i < qt; i++) {
            JOptionPane.showMessageDialog(null, "Livro " + (i + 1));
            this.nome[i] = JOptionPane.showInputDialog("Digite o nome do livro:");
            this.autor[i] = JOptionPane.showInputDialog("Digite o nome do autor:");
            this.editora[i] = JOptionPane.showInputDialog("Digite o nome da editora:");
            this.ano[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento:"));
        }

        JOptionPane.showMessageDialog(null, this.qt + " livros registrados!");
    }

    public void listarLivros() {
        String msg = "Livros Cadastrados:\n\n";

        for (int i = 0; i < qt; i++) {
            msg = msg + "Nome do livro: " + this.nome[i];
            msg = msg + "\nNome do autor: " + this.autor[i];
            msg = msg + "\nEditora: " + this.editora[i];
            msg = msg + "\nAno de lançamento: " + this.ano[i] + "\n\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public void Menu() {
        String[] op = {"Cadastrar Livros", "Listar Livros", "Sair"};
        int menu = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu Principal",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);

        switch(menu) {
            case 0:
            cadastrarLivros();
            break;

            case 1:
            listarLivros();
            break;

            default:
            System.exit(0);
        }
    }
}
