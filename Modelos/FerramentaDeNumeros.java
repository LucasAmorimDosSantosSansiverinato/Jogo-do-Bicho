package Modelos;

// import java.util.Random;
import javax.swing.JOptionPane;

import Library.FerramentaDeNumerosTexts;
import Usuario.CarteiraDoUsuario;

public class FerramentaDeNumeros {

    public  int milhar;
    public  int centena;
    public   int dezena;
    public  int unidade;
    public  int numeroSorteado = numeroAleatorioEmMilhar();
    public  int premio;

    public  int precoTickt;
    public  String tipoDeJogo;
    public  int numeroDoUsuario;

    // Essa variavel é utulizada em todos os Metodos
    private  boolean entradaValida = false;

    // Variaveis utilidas nos Metodos ValidaEscolhaMilhar e PremiaMilhar
     public  int numeroApostado   = 0;
     public  int numeroDesmembrado = 0;

     
    public  CarteiraDoUsuario novaCarteira = new CarteiraDoUsuario();
    public  Botoes novoBotao = new Botoes();

     
    // Aqui é gerado o numero aleatorio
    public  int numeroAleatorioEmMilhar() {
        // Random aleatorio = new Random();

        int numeroAleatorioEmMilhar = 5263; // aleatorio.nextInt(9000) + 1000;

        return numeroAleatorioEmMilhar;
    }

    /*
     * recebe um numero aleatorio e desmebra ele para ser usando nas validações de
     * Milhar, Centena, Dezena
     */
    public  int desmembrarNumero ( String tipo ) {
        tipoDeJogo = tipo;

        if (tipo.equals("milhar")) {

            return numeroAleatorioEmMilhar();

        } else if (tipo.equals("centena")) {

            return numeroAleatorioEmMilhar() % 1000;

        } else if (tipo.equals("dezena")) {

            return numeroAleatorioEmMilhar() % 100;

        } else if (tipo.equals("unidade")) {

            return numeroAleatorioEmMilhar() % 10;

        } else {
            return 0;
        }

    }

    /*
     * Aqui acontece o jogo de milhar onde é relizada valição do numero inserido
     * pelo usuario, a compração dos numeros e tambem para o usuario
     */
    public  int ValidaEscolhaMilhar() {

        do { // Valida escolha Milhar
            numeroDoUsuario = Integer
                    .parseInt(JOptionPane.showInputDialog(null, FerramentaDeNumerosTexts.texto1));

            

            // Validar a entrada do usuário
            if (numeroDoUsuario < 1000 || numeroDoUsuario > 9999) {
                JOptionPane.showMessageDialog(null, FerramentaDeNumerosTexts.texto1_2);

                numeroDoUsuario=0;

            } else {
                entradaValida = true;
            }
        } while (!entradaValida);

        return numeroDoUsuario;
    }

    // Metodo que paga ao usuario o premio dele
    public  void PremiaGenerico( ) {
        System.out.println("\nAcessou o metodo PremiaMilhar\n");

        if (numeroDoUsuario == numeroDesmembrado) {
            // 10 Reais
            if (Botoes.salvaValor == 0) {

                if (tipoDeJogo.equals("milhar")) {

                    premio += precoTickt * 10000;

                    novaCarteira.depositarPremioNaCarteira(premio);

                    JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

                } else if (tipoDeJogo.equals("centena")) {

                    premio += precoTickt * 1000;

                    novaCarteira.depositarPremioNaCarteira(premio);

                    JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

                }
                else if (tipoDeJogo.equals("dezena")) {

                    premio += precoTickt * 100;

                    novaCarteira.depositarPremioNaCarteira(premio);

                    JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

                }
               else if (tipoDeJogo.equals("animal")) {

                    premio += precoTickt * 10;

                    novaCarteira.depositarPremioNaCarteira(premio);

                    JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

                }

            }
            premio = 0;
        }

    }

    /*
     * Aqui acontece o jogo de Centena onde é relizada valição do numero inserido
     * pelo usuario, a compração dos numeros e tambem para o usuario
     */
    public  int ValidaEscolhaCentena() {

        do { // Valida escolha Centena
            numeroDoUsuario = Integer
                    .parseInt(JOptionPane.showInputDialog(null, FerramentaDeNumerosTexts.texto2));



            // Validar a entrada do usuário
            if (numeroDoUsuario < 100 || numeroDoUsuario > 999) {
                JOptionPane.showMessageDialog(null, FerramentaDeNumerosTexts.texto2_2);

                numeroDoUsuario=0;
            
            } else {
                entradaValida = true;
            }
        } while (!entradaValida);

        return numeroDoUsuario;
    }

    /*
     * Aqui acontece o jogo de Dezena onde é relizada valição do numero inserido
     * pelo usuario, a compração dos numeros e tambem para o usuario
     */
    public  int ValidaEscolhaDezena() {

        do {
            // Valida escolha Dezena
            numeroDoUsuario = Integer
                    .parseInt(JOptionPane.showInputDialog(null, FerramentaDeNumerosTexts.texto3));

            

            // Validar a entrada do usuário
            if (numeroDoUsuario < 10 || numeroDoUsuario > 99) {
                JOptionPane.showMessageDialog(null, FerramentaDeNumerosTexts.texto3_2);

                numeroDoUsuario=0;

            } else {
                entradaValida = true;
            }
        } while (!entradaValida);

        return numeroDoUsuario;
        // PremiaDezena(numeroAleatorioEmMilhar);
    }

    public  void resultadoDeTodosOsJogos(int numeroAleatorioEmMilhar) {

        JOptionPane.showMessageDialog(null,
                FerramentaDeNumerosTexts.texto3_5 + numeroAleatorioEmMilhar + FerramentaDeNumerosTexts.texto3_5_6
                        + numeroAleatorioEmMilhar % 1000
                        + FerramentaDeNumerosTexts.texto3_5_6_7 + numeroAleatorioEmMilhar % 100);

    }

    /*
     * Aqui é onde o usuario escolher o valor que ele quer apostar, sendo os valores
     * 10, 20, 30, 40
     */

    public  int valorDosJogos() {
        var novoBotao = new Botoes();
        var novaCarteira = new CarteiraDoUsuario();

        switch (novoBotao.valorDaAposta()) {
            case 0:

                // Cobrar um valor da cateira toda vez que paga para jogar
                novaCarteira.debitarDaCarteira(novaCarteira.getCarteira(), FerramentaDeNumerosTexts.number1);

                precoTickt = 10;
                break;
            case 1:

                // Cobrar um valor da cateira toda vez que paga para jogar
                novaCarteira.debitarDaCarteira(novaCarteira.getCarteira(), FerramentaDeNumerosTexts.number2);

                precoTickt = 20;
                break;
            case 2:

                // Cobrar um valor da cateira toda vez que paga para jogar
                novaCarteira.debitarDaCarteira(novaCarteira.getCarteira(), FerramentaDeNumerosTexts.number3);

                precoTickt = 30;
                break;
            case 3:

                // Cobrar um valor da cateira toda vez que paga para jogar
                novaCarteira.debitarDaCarteira(novaCarteira.getCarteira(), FerramentaDeNumerosTexts.number4);

                precoTickt = 40;
                break;
            case 4:

                // Volta para o Menu
                Menu.main(null);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
        }

        return precoTickt;

    }

}