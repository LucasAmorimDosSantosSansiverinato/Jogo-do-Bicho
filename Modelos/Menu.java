package Modelos;

import javax.swing.JOptionPane;

import Usuario.CarteiraDoUsuario;

public class Menu {
    public static void main(String[] args) {

        Execucao executar = new Execucao();

        var novaCarteira = new CarteiraDoUsuario();

        int option;

        do {
            String[] options = { "Jogar", "Depositar", "Ver Saldo" };
            option = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0: // Jogar
                    // executar.alterarSaldo ( novaCarteira.carteira );
                    executar.motor(novaCarteira);

                    break;
                case 1: // Depositar

                    String input = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");

                    int valor = Integer.parseInt(input);
                    if (valor < 0 || valor > 1000) {
                        JOptionPane.showMessageDialog(null, "Valor deve ser positivo entre 0 e 1000!");

                    } else {
                        novaCarteira.depositarSaldoNaConta(valor);
                        
                    }

                    break;
                case 2: // Ver Saldo
                    verSaldo(novaCarteira.carteira);

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (option != 3);
    }

    public static void verSaldo(int saldo) {
        JOptionPane.showMessageDialog(null, "Seu saldo atual é: R$" + saldo);
    }

}
