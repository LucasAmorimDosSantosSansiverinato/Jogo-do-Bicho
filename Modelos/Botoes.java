package Modelos;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Library.BotoesTexts;

public class Botoes {

    // Painel Inicial
    private  int painelInicial() {

        UIManager.put(BotoesTexts.texto1, BotoesTexts.textos);
        UIManager.put(BotoesTexts.texto1_2, BotoesTexts.texton);

        Object[] options = { BotoesTexts.textos, BotoesTexts.texton };

        int yesOrNo = JOptionPane.showOptionDialog(null,
                BotoesTexts.texto2,
                BotoesTexts.textoc,
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                null,
                options,
                options[0]);

        return yesOrNo;
    }

    public int getPalnelInicial() {
        return painelInicial();
    }

     int salvaEstiloDeJogo;

    // estilo de jogo
    private  int EstiloDeJogo() {
        Object[] botao = { BotoesTexts.texto3, BotoesTexts.texto3_2, BotoesTexts.texto3_3, BotoesTexts.texto3_4,
                BotoesTexts.texto3_5 };

        int classeDeAposta = JOptionPane.showOptionDialog(null, BotoesTexts.texto3_6,
                BotoesTexts.texto3_7, 0, 0,
                null,
                botao, botao[0]);
            salvaEstiloDeJogo=classeDeAposta;
        return classeDeAposta;

    }

    public int getEstiloDeJogo() {
        return EstiloDeJogo();
    }

     int salvaValor;
    // Valor da aposta
    public int valorDaAposta() {
        Object[] tecla = { BotoesTexts.texto4, BotoesTexts.texto4_2, BotoesTexts.texto4_3, BotoesTexts.texto4_4,
                BotoesTexts.texto3_5 };

        int valorInserido = JOptionPane.showOptionDialog(null, BotoesTexts.texto4_5, BotoesTexts.texto4_6, 0, 0,
                null,
                tecla, tecla[0]);
        
            salvaValor=valorInserido;

        return valorInserido;

    }

    /* Botão para ver o resultado dos outros tipos de Jogos "Animal", "Milhar",
    "Dezena", "Centena"*/
    public int verOutrosJogos() {

        UIManager.put(BotoesTexts.texto1, BotoesTexts.textos);
        UIManager.put(BotoesTexts.texto1_2, BotoesTexts.texton);

        Object[] options = { BotoesTexts.textos, BotoesTexts.texton };

        int yesOrNo = JOptionPane.showOptionDialog(null,
                BotoesTexts.texto5,
                BotoesTexts.textoc,
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                null,
                options,
                options[0]);

        return yesOrNo;

    }

    // Botão para Jogar novamente
    public int jogarNovamente() {

        UIManager.put(BotoesTexts.texto1, BotoesTexts.textos);
        UIManager.put(BotoesTexts.texto1_2, BotoesTexts.texton);

        Object[] options = {BotoesTexts.textos, BotoesTexts.texton };

        int yesOrNo = JOptionPane.showOptionDialog(null,
                BotoesTexts.texto6,
                BotoesTexts.textoc,
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                null,
                options,
                options[0]);

        return yesOrNo;
    }



    public  int salvaNovoJogoFinalizar;

     // NovoJogo Finalizar
     public  int NovoJogoFinalizar() {
        Object[] botao = {"Novo Jogo", "Ver Jogos" ,"Finalizar"};

        int escolha = JOptionPane.showOptionDialog(null, "Desejar Finalizar e ver o resultado da aposta ou adicionar mais uma aposta?",
                BotoesTexts.texto3_7, 0, 0,
                null,
                botao, botao[0]);

                salvaNovoJogoFinalizar=escolha;
                
        return escolha;

    }

    
   

}
