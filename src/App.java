import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    static List<Livros> livros = new ArrayList<>();

    public static void ErrorMessage() {
        JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void cadastrarLivros() {
        boolean repeat = true;
        Integer qt = 0;

        do {
            try {

                qt = Integer.parseInt(JOptionPane.showInputDialog("Quantos livros deseja cadastrar?"));

                repeat = false;

            } catch (Exception e) {
                ErrorMessage();
            }
        } while (repeat == true);

        for (int i = 0; i < qt; i++) {
            repeat = true;

            JOptionPane.showMessageDialog(null, "Livro " + (i + 1));

            do {
                try {

                    String nome = JOptionPane.showInputDialog("Digite o nome do livro:");
                    String autor = JOptionPane.showInputDialog("Digite o nome do autor:");
                    String editora = JOptionPane.showInputDialog("Digite o nome da editora:");
                    Integer ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento:"));

                    livros.add(new Livros(nome, autor, editora, ano));

                    repeat = false;

                } catch (Exception e) {
                    ErrorMessage();
                }
            } while (repeat == true);
        }

        if (qt == 1) JOptionPane.showMessageDialog(null, qt + " livro registrado com sucesso!", "Registro", JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null, qt + " livros registrados com sucesso!", "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void listarLivros() {
        String msg = "Livros Registrados:\n";

        for (Livros livro : livros) {
            msg += "\n----------------------------------------------";
            msg += "\nNome do livro: " + livro.nome;
            msg += "\nAutor: " + livro.autor;
            msg += "\nEditora: " + livro.editora;
            msg += "\nAno de Lançamento: " + livro.ano;   
        }

        msg += "\n----------------------------------------------";

        JOptionPane.showMessageDialog(null, msg, "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Menu() {
        String[] op = {"Cadastrar Livros", "Listar Livros", "Sair"};
        Integer menu = JOptionPane.showOptionDialog(null, "Selecione uma Opção:", "Menu Principal",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

        switch (menu) {
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
    public static void main(String[] args) {
        for (boolean repeat = true; repeat == true;) {
            Menu();
        }
    }
}

class Livros {
    String nome, autor, editora;
    Integer ano;

    public Livros(String n, String a, String e, Integer an) {
        this.nome = n;
        this.autor = a;
        this.editora = e;
        this.ano = an;
    } 
}