package Modelos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Library.ExecutarTexts;
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

        String tipo = null;

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
                    tipo = "animal";
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
                    tipo = "numero";
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

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroDesmembrado = FerramentaDeNumeros.desmembrarNumero(numeroAleatorio, "milhar");

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroEscolhido = FerramentaDeNumeros.ValidaEscolhaMilhar();
                    break;

                case 2:// Centena
                    tipo = "numero";

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

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroEscolhido = FerramentaDeNumeros.desmembrarNumero(numeroAleatorio, "centena");

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroDesmembrado = FerramentaDeNumeros.ValidaEscolhaCentena();

                    break;

                case 3:// Dezena
                    tipo = "numero";

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

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroEscolhido = FerramentaDeNumeros.desmembrarNumero(numeroAleatorio, "dezena");

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroDesmembrado = FerramentaDeNumeros.ValidaEscolhaDezena();
                    break;

                case 4:

                    // Volta para o Menu
                    Menu.main(null);
                    break;

                default:
            }

            // Opção para mostrar o resultado da aposta em Animal 
            if (tipo.equals("animal")) {

                CarrinhoDeAposta outroAposta = new CarrinhoDeAposta(TabelaAnimal.numeroQueUsuarioEscolheu,
                        TabelaAnimal.mostraAnimalSorteado, TabelaAnimal.numeroDoAnimalSorteado);
                listaDeApostas.add(outroAposta);
                for (var apostaAnimal : listaDeApostas) {
                    if (apostaAnimal.numeroInseridoPeloUsuario == TabelaAnimal.numeroDoAnimalSorteado) {
                        JOptionPane.showMessageDialog(null,
                                "Parabéns! Você ganhou! O animal sorteado foi: " + TabelaAnimal.mostraAnimalSorteado);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Que pena! Você perdeu! O animal sorteado foi: " + TabelaAnimal.mostraAnimalSorteado);
                    }
                }
                // Opção para mostrar o resultado da aposta em Numeros
            } else if (tipo.equals("numero")) {

                CarrinhoDeAposta novaAposta = new CarrinhoDeAposta(FerramentaDeNumeros.numeroDoUsuario,
                        FerramentaDeNumeros.tipoDeJogo, FerramentaDeNumeros.precoTickt);
                listaDeApostas.add(novaAposta);

                for (var aposta : listaDeApostas) {
                    System.out
                            .println("Numero Apostado: " + aposta.numeroInseridoPeloUsuario + "\n Modalidade Apostada: "
                                    + aposta.modalidadeDeJogo);
                }

                Botoes.NovoJogoFinalizar();// Aqui é chamado o Painel onde aparece os botões (Novo Jogo) = 0 , (Ver Jogos) = 1 , (Finalizar) = 2
                                        

                if (Botoes.salvaNovoJogoFinalizar == 0) {
                    novojogo = true;
                } else if (Botoes.salvaNovoJogoFinalizar == 1) {
                    for (var VerAposta : listaDeApostas) {

                        // Mostra ao usuario as apostas feitas antes de Finalizar
                        JOptionPane.showMessageDialog(null,
                                "Numero apostado: " + VerAposta.numeroInseridoPeloUsuario
                                        + "\nEstilo de Jogo: " + VerAposta.modalidadeDeJogo + "\nValor pago: "
                                        + VerAposta.valorPagoPeloUsuario);

                                        novojogo=true;
                    }
                }

                // Opção para Finalizar e mostrar o resultado das apostas
                else if (Botoes.salvaNovoJogoFinalizar == 2)// Aqui é utilizado o valor dos botões para autorizar a ação
                {
                    System.out.println("\nAcessou o painel NovoJogo Finalizar\n");

                    for (var aposta : listaDeApostas) {
                        if (aposta.numeroInseridoPeloUsuario == numeroDesmembrado) {
                            // se o numero apostado for igual ao numero desmebrado


                            // Esse painel mostra o resultado de uma aposta por vez, quero mudar para mostrar de todas ao msm tempo
                            JOptionPane.showMessageDialog(null,
                                    "Numero apostado: " + aposta.numeroInseridoPeloUsuario
                                            + "\nEstilo de Jogo: " + aposta.modalidadeDeJogo + "\nValor pago: "
                                            + aposta.valorPagoPeloUsuario + "\n\n\nResultado: "
                                            + numeroDesmembrado
                                            + "\n\nParabens vc acertoou!!");

                            System.out.println("Numero que o usuario digitou: " + numeroEscolhido);

                        } else {
                            // Caso o numero sorteado esteja errado


                             // Esse painel mostra o resultado de uma aposta por vez, quero mudar para mostrar de todas ao msm tempo
                            JOptionPane.showMessageDialog(null,
                                    "Numero apostado: " + aposta.numeroInseridoPeloUsuario
                                            + "\nEstilo de Jogo: " + aposta.modalidadeDeJogo + "\nValor pago: "
                                            + aposta.valorPagoPeloUsuario + "\n\n\nResultado: "
                                            + numeroDesmembrado
                                            + "\n\nDesculpe vc errou!!");

                            System.out.println("Numero que o usuario digitou: " + numeroEscolhido);
                        }
                    }

                }
            }

        }

    }

}
