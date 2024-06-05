package Modelos;

import javax.swing.JOptionPane;

import Usuario.CarteiraDoUsuario;

public class Menu {
    public static void main(String[] args) {


        Execucao executar = new Execucao(); 

        var novaCarteira = new CarteiraDoUsuario();
       

        int option;

        do {
            String[] options = { "Jogar", "Depositar", "Ver Saldo"};
            option = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0: // Jogar
                    int saldo = novaCarteira.getCarteira();

                    executar.alterarSaldo ( saldo );
                    executar.motor();

                    break;
                case 1: // Depositar
                    novaCarteira.depositarSaldoNaConta();
                    executar.alterarSaldo(novaCarteira.getCarteira());

                    break;
                case 2: // Ver Saldo
                    verSaldo(novaCarteira.getCarteira());

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (option != 3);
    }

    public static int depositar(int saldoAtual) {
        String input = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
        try {
            int valor = Integer.parseInt(input);
            if (valor < 0) {
                JOptionPane.showMessageDialog(null, "O valor não pode ser negativo!");

            } else if (valor > 0 && valor < 1000) {
                saldoAtual += valor;
                JOptionPane.showMessageDialog(null, "Depósito de R$" + valor + " realizado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "O valor deve ser positivo e menor que 1000!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        }
        return saldoAtual;
    }

    public static void verSaldo(int saldo) {
        JOptionPane.showMessageDialog(null, "Seu saldo atual é: R$" + saldo);
    }

   
}
