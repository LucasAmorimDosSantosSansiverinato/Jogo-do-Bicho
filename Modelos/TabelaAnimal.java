
package Modelos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Usuario.CarteiraDoUsuario;

import java.awt.Color;
import java.awt.Font;
   //  import java.util.Random;

public class TabelaAnimal extends JFrame {
    static int premio;

    static String mostraAnimalSorteado="";

    static int numeroDoAnimalSorteado;

    static int numeroQueUsuarioEscolheu;

    private static final String[] ANIMAIS = {
            "Avestruz", "Águia", "Burro", "Borboleta", "Cachorro",
            "Cabra", "Carneiro", "Camelo", "Cobra", "Coelho",
            "Cavalo", "Elefante", "Galo", "Gato", "Jacaré",
            "Leão", "Macaco", "Porco", "Pavão", "Peru",
            "Touro", "Tigre", "Urso", "Veado", "Vaca"
    };
    private static String aposta;

    // Método principal
    public static void main(String[] args) {

        var novaCarteira = new CarteiraDoUsuario();
       
        

        // Exibir a tabela de animais com seus respectivos números
        exibirTabela();

        // Gerar o número aleatório e encontrar o animal correspondente
        int numeroSorteado = gerarNumeroAleatorio();
        String animalSorteado = encontrarAnimal(numeroSorteado);

        // numero aleatorio
        numeroDoAnimalSorteado = numeroSorteado;

        // Animal
        mostraAnimalSorteado=animalSorteado;

        // Obter a aposta do usuário
        boolean entradaValida = false;
        while (!entradaValida) {
            aposta = JOptionPane.showInputDialog("Digite um número entre 1 e 25:");
            if (!aposta.matches("[0-9]+")) { // verificar se a String é apenas numeros contendo 0 até 9 tirando a
                                             // possibilidade de ter letras
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite apenas números.");
                continue; // Continuar com a próxima iteração do loop
            }
            try {
                int numAposta = Integer.parseInt(aposta);

                numeroQueUsuarioEscolheu = numAposta;

                if (numAposta < 1 || numAposta > 25) {
                    JOptionPane.showMessageDialog(null, "Número inválido. Por favor, digite um número entre 1 e 25.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número entre 1 e 25.");
            }
        }

        // Validar a escolha da dezena
        String dezenaSorteada = validarEscolhaDezena(numeroSorteado);

        // Exibir o resultado
        if (aposta.equalsIgnoreCase(dezenaSorteada)) {
            

            // 10 Reais
            if (Botoes.salvaValor == 0) {
                premio += 20;
              novaCarteira.depositarPremioNaCarteira(premio);
            } // 20 reais
            else if (Botoes.salvaValor == 1) {
                premio += 40;
                novaCarteira.depositarPremioNaCarteira(premio);
            } // 30 reais
            else if (Botoes.salvaValor == 2) {
                premio += 60;
                novaCarteira.depositarPremioNaCarteira(premio);
            } // 40 reais
            else if (Botoes.salvaValor == 3) {
                premio += 80;
                novaCarteira.depositarPremioNaCarteira(premio);
            }

            

        } 
    }

    // Método para exibir a tabela de animais com seus respectivos números
    private static void exibirTabela() {
        // Criando o modelo da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número");
        model.addColumn("Animal");

        // Preenchendo a tabela com os dados
        for (int i = 0; i < ANIMAIS.length; i++) {
            model.addRow(new Object[] { i + 1, ANIMAIS[i] });
        }

        // Criando a tabela com o modelo
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(25);

        // Exibindo a tabela em um JOptionPane dentro de um JScrollPane para rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Tabela do Jogo do Bicho",
                JOptionPane.PLAIN_MESSAGE);
    }

    // Método para gerar um número aleatório entre 1000 e 9999
    private static int gerarNumeroAleatorio() {
        return 5; //new Random().nextInt(25) + 1;
    }

    // Método para encontrar o animal correspondente ao número sorteado
    private static String encontrarAnimal(int numeroSorteado) {
        int indice = (numeroSorteado - 1) % ANIMAIS.length;
        return ANIMAIS[indice];
    }

    // Método para validar a escolha da dezena
    private static String validarEscolhaDezena(int numeroSorteado) {
        int dezena = numeroSorteado;
        return String.valueOf(dezena);
    }
}
