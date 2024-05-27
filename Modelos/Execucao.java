package Modelos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Library.ExecutarTexts;
import Library.FerramentaDeNumerosTexts;
import Usuario.CarteiraDoUsuario;

public class Execucao {

    public static int motor() {

        ArrayList<CarrinhoDeAposta> listaDeApostas = new ArrayList<>();

        Botoes novoBotao = new Botoes();

        CarteiraDoUsuario novaCarteira = new CarteiraDoUsuario();
        int contador = 0;

        var numeroAleatorio = FerramentaDeNumeros.numeroAleatorioEmMilhar();
        var numeroDesmembrado = 0;
        var numeroEscolhido = 0;
        boolean novojogo = false;

        while (true) {

            if (contador >= 1 && !novojogo) {
                switch (novoBotao.jogarNovamente()) {
                    case JOptionPane.YES_OPTION:

                        break;
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                    default:
                        break;
                }

            }
            // informa que o usuario esta sem saldo
            contador++;
            if (novaCarteira.getCarteira() <= 0) {

                JOptionPane.showMessageDialog(null, ExecutarTexts.texto1);
                return 0;
            }
            

            switch (novoBotao.getEstiloDeJogo()) {

                case 0: // Tabela Animal
                    JOptionPane.showMessageDialog(null,
                            """
                                    Para animal:
                                    Se apostar R$ 10,00 = premio vai ser R$ 20,00!
                                    Se apostar R$ 20,00 = premio vai ser R$ 40,00!
                                    Se apostar R$ 30,00 = premio vai ser R$ 60,00!
                                    Se apostar R$ 40,00 = premio vai ser R$ 80,00!
                                        """);

                    // Leva até o metodo que faz a cobrança para jogar
                    FerramentaDeNumeros.valorDosJogos();

                    // Executa a class onde estão o animais
                    TabelaAnimal.main(null);
                    break;
                case 1: // Milhar
                    JOptionPane.showMessageDialog(null,
                            """
                                    Para Milhar:
                                    Se apostar R$ 10,00 = premio vai ser R$ 10.000,00!
                                    Se apostar R$ 20,00 = premio vai ser R$ 20.000,00!
                                    Se apostar R$ 30,00 = premio vai ser R$ 30.000,00!
                                    Se apostar R$ 40,00 = premio vai ser R$ 40.000,00!
                                        """);
                    // Leva até o metodo que faz a cobrança para jogar
                    FerramentaDeNumeros.valorDosJogos();

                    numeroDesmembrado = FerramentaDeNumeros.desmembrarNumero(numeroAleatorio, "milhar");
                    // Leva até metodo que valida a escolha em milhar
                    numeroEscolhido = FerramentaDeNumeros.ValidaEscolhaMilhar(numeroAleatorio);
                    
                    // Vê o reultado dos outros Jogos
                    if (novoBotao.verOutrosJogos() == JOptionPane.YES_OPTION) {

                        FerramentaDeNumeros.resultadoDeTodosOsJogos(numeroAleatorio);
                    }
                    break;
                case 2:// Centena
                    JOptionPane.showMessageDialog(null,
                            """
                                    Para Centena:
                                    Se apostar R$ 10,00 = premio vai ser R$ 2.000,00!
                                    Se apostar R$ 20,00 = premio vai ser R$ 3.000,00!
                                    Se apostar R$ 30,00 = premio vai ser R$ 4.000,00!
                                    Se apostar R$ 40,00 = premio vai ser R$ 5.000,00!
                                        """);
                    // Leva até o metodo que faz a cobrança para jogar
                    FerramentaDeNumeros.valorDosJogos();

                    // Leva até metodo que valida a escolha em milhar
                    FerramentaDeNumeros.ValidaEscolhaCentena(FerramentaDeNumeros.numeroAleatorioEmMilhar());

                    // Vê o reultado dos outros Jogos
                    if (novoBotao.verOutrosJogos() == JOptionPane.YES_OPTION) {
                        FerramentaDeNumeros.resultadoDeTodosOsJogos(FerramentaDeNumeros.numeroAleatorioEmMilhar());
                    }
                    break;
                case 3:// Dezena
                    JOptionPane.showMessageDialog(null,
                            """
                                    Para Dezena:
                                    Se apostar R$ 10,00 = premio vai ser R$ 100,00!
                                    Se apostar R$ 20,00 = premio vai ser R$ 200,00!
                                    Se apostar R$ 30,00 = premio vai ser R$ 300,00!
                                    Se apostar R$ 40,00 = premio vai ser R$ 400,00!
                                        """);
                    // Leva até o metodo que faz a cobrança para jogar
                    FerramentaDeNumeros.valorDosJogos();

                    // Leva até metodo que valida a escolha em milhar
                    FerramentaDeNumeros.ValidaEscolhaDezena(FerramentaDeNumeros.numeroAleatorioEmMilhar());

                    // Vê o reultado dos outros Jogos
                    if (novoBotao.verOutrosJogos() == JOptionPane.YES_OPTION) {
                        FerramentaDeNumeros.resultadoDeTodosOsJogos(FerramentaDeNumeros.numeroAleatorioEmMilhar());
                    }

                    System.exit(0);
                    break;

                case 4:

                    // Volta para o Menu
                    Menu.main(null);
                    break;

                default:
            }

            CarrinhoDeAposta novaAposta = new CarrinhoDeAposta(FerramentaDeNumeros.numeroDoUsuario,FerramentaDeNumeros.tipoDeJogo, FerramentaDeNumeros.precoTickt);
            listaDeApostas.add(novaAposta);

            for (var aposta : listaDeApostas){
                System.out.println("Numero Apostado: " + aposta.numeroInseridoPeloUsuario + "\n Modalidade Apostada: " + aposta.modalidadeDeJogo);
            }

            Botoes.NovoJogoFinalizar();// Aqui é chamado o Painel onde aparece os botões (Novo Jogo) = 0 , (Ver Jogos) = 1 , (Finalizar) = 2 
            
            if (Botoes.salvaNovoJogoFinalizar == 0){
                novojogo = true;
            }

            else if (Botoes.salvaNovoJogoFinalizar == 2)// Aqui é utilizado o valor dos botões para autorizar a ação
            {
                System.out.println("\nAcessou o painel NovoJogo Finalizar\n");

                // // se o numero apostado for igual ao numero desmebrado
                for (var aposta : listaDeApostas){
                    if (aposta.numeroInseridoPeloUsuario == numeroDesmembrado) {
                        JOptionPane.showMessageDialog(null, FerramentaDeNumerosTexts.texto1_3
                                + numeroAleatorio);
                        System.out.println("Numero que o usuario digitou: " + numeroEscolhido);

                        FerramentaDeNumeros.TelaDeResultadosPreco();
                    
                    } else {
                        // Caso o numero sorteado em milhar esteja errado
                        JOptionPane.showMessageDialog(null, FerramentaDeNumerosTexts.texto1_4
                                + numeroAleatorio);
                        System.out.println("Numero que o usuario digitou: " + numeroEscolhido);
                    }
                }
                //FerramentaDeNumeros.PremiaMilhar(numeroAleatorio);
            }

        }

    }

}
