package Modelos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Library.ExecutarTexts;
import Usuario.CarteiraDoUsuario;

public class Execucao {
    public int premio;
    public int precoTickt;

    public ArrayList<CarrinhoDeAposta> listaDeApostas = new ArrayList<>();

    // public void zerarApostas(){
    // listaDeApostas=null;
    // }

    public int desmembrar(int num, String tipo) {

        String str = String.valueOf(num);
        String resultado = "";

        if (tipo.equals("dezena")) {

            resultado = str.substring(str.length() - 2, str.length());

        } else if (tipo.equals("centena")) {
            resultado = str.substring(str.length() - 3, str.length());

        } else {
            resultado = str.substring(str.length() - 4, str.length());
        }

        return Integer.parseInt(resultado);

    }

    public void motor() {

        FerramentaDeNumeros f1 = new FerramentaDeNumeros();

        Botoes novoBotao = new Botoes();

        CarteiraDoUsuario novaCarteira = new CarteiraDoUsuario();
        

        var numeroAleatorio = f1.numeroAleatorioEmMilhar();
        var numeroDesmembrado = 0;
        var numeroEscolhido = 0;
        boolean novojogo = false;

        String tipo = null;

        while (true) {

            // informa que o usuario esta sem saldo

            if (novaCarteira.getCarteira() <= 0) {

                JOptionPane.showMessageDialog(null, "Necessário fazer o depósito primeiro! Error!");
                System.exit(0);
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
                    f1.valorDosJogos();

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
                    f1.valorDosJogos();

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroDesmembrado = f1.desmembrarNumero("milhar");

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroEscolhido = f1.ValidaEscolhaMilhar();
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
                    f1.valorDosJogos();

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroEscolhido = f1.ValidaEscolhaCentena();

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroDesmembrado = f1.desmembrarNumero("centena");

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
                    f1.valorDosJogos();

                    // Faz a validação de qual é o estilo de jogo e desmembra o numero de acordo
                    numeroEscolhido = f1.ValidaEscolhaDezena();

                    // Atribui o valor do retorn da ValidaEscolha a variavel
                    numeroDesmembrado = f1.desmembrarNumero("dezena");
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
                        TabelaAnimal.mostraAnimalSorteado, TabelaAnimal.numeroDoAnimalSorteado, numeroDesmembrado);
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

                CarrinhoDeAposta novaAposta = new CarrinhoDeAposta(f1.numeroDoUsuario,
                        f1.tipoDeJogo, f1.precoTickt, numeroDesmembrado);
                listaDeApostas.add(novaAposta);

                for (var aposta : listaDeApostas) {
                    System.out
                            .println("Numero Apostado: " + aposta.numeroInseridoPeloUsuario + "\n Modalidade Apostada: "
                                    + aposta.modalidadeDeJogo);
                }

                Botoes.NovoJogoFinalizar();// Aqui é chamado o Painel onde aparece os botões (Novo Jogo) = 0 , (Ver
                                           // Jogos) = 1 , (Finalizar) = 2

                if (Botoes.salvaNovoJogoFinalizar == 0) {
                    novojogo = true;

                } else if (Botoes.salvaNovoJogoFinalizar == 1) {

                    for (var VerAposta : listaDeApostas) {

                        // Mostra ao usuario as apostas feitas antes de Finalizar
                        JOptionPane.showMessageDialog(null,
                                "Numero apostado: " + VerAposta.numeroInseridoPeloUsuario
                                        + "\nEstilo de Jogo: " + VerAposta.modalidadeDeJogo + "\nValor pago: "
                                        + VerAposta.valorPagoPeloUsuario);

                        novojogo = true;
                    }
                }

                // Opção para Finalizar e mostrar o resultado das apostas
                else if (Botoes.salvaNovoJogoFinalizar == 2)// Aqui é utilizado o valor dos botões para autorizar a ação
                {
                    System.out.println("\nAcessou o painel Finalizar\n");

                    for (var aposta : listaDeApostas) {

                        if (aposta.numeroInseridoPeloUsuario == f1.desmembrarNumero("dezena")
                                || aposta.numeroInseridoPeloUsuario == f1.desmembrarNumero("centena")
                                || aposta.numeroInseridoPeloUsuario == f1.desmembrarNumero("milhar")) {
                            // se o numero apostado for igual ao numero desmebrado

                            // Esse painel mostra o resultado de uma aposta por vez, quero mudar para
                            // mostrar de todas ao msm tempo

                            if (aposta.numeroInseridoPeloUsuario != 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Numero apostado: " + aposta.numeroInseridoPeloUsuario
                                                + "\nEstilo de Jogo: " + aposta.modalidadeDeJogo + "\nValor pago: "
                                                + aposta.valorPagoPeloUsuario + "\n\n\nResultado: "
                                                + desmembrar(numeroAleatorio, aposta.modalidadeDeJogo)
                                                + "\n\nParabens vc acertoou!!");
                            }

                            System.out.println("Numero que o usuario digitou: " + numeroEscolhido);

                        }

                        // Caso o numero sorteado esteja errado
                        // Esse painel mostra o resultado de uma aposta por vez, quero mudar para
                        // mostrar de todas ao msm tempo

                        if (aposta.numeroInseridoPeloUsuario != 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Numero apostado: " + aposta.numeroInseridoPeloUsuario
                                            + "\nEstilo de Jogo: " + aposta.modalidadeDeJogo + "\nValor pago: "
                                            + aposta.valorPagoPeloUsuario + "\n\n\nResultado: "
                                            + desmembrar(numeroAleatorio, aposta.modalidadeDeJogo)
                                            + "\n\nDesculpe vc errou!!");
                        }

                        int resp = JOptionPane.showConfirmDialog(null, "Quer Jogar novamente ", "Confirma Operação!",
                                JOptionPane.YES_NO_OPTION);

                        if (resp == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }

                        // */ switch ( novoBotao.jogarNovamente() ) {
                        // case JOptionPane.YES_OPTION:

                        // break;
                        // case JOptionPane.NO_OPTION:
                        // System.exit(0);
                        // default:
                        // break;
                        // }
                        /* */

                        System.out.println("Numero que o usuario digitou: " + numeroEscolhido);

                    }

                }

            }
        }
    }
}

    // Metodo que paga ao usuario o premio dele
    public int PremiaGenerico() {

        System.out.println("\nAcessou o metodo PremiaMilhar\n");

        // 10 Reais
        if (Botoes.salvaValor == 0) {

            if (aposta.modalidadeDeJogo.equals(f1.desmembrarNumero("milhar"))) {

                premio += precoTickt * 10000;

                novaCarteira.depositarPremioNaCarteira(premio);

                JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

            } else if (aposta.modalidadeDeJogo.equals(f1.desmembrarNumero("centena"))) {

                premio += precoTickt * 1000;

                novaCarteira.depositarPremioNaCarteira(premio);

                JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

            } else if (aposta.modalidadeDeJogo.equals(f1.desmembrarNumero("dezena"))) {

                premio += precoTickt * 100;

                novaCarteira.depositarPremioNaCarteira(premio);

                JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

            } else if (f1.tipoDeJogo.equals("animal")) {

                premio += precoTickt * 10;

                novaCarteira.depositarPremioNaCarteira(premio);

                JOptionPane.showMessageDialog(null, "Parabens vc ganhou " + premio);

            }

        }
        premio = 0;
    }