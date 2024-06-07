package Modelos;

public class CarrinhoDeAposta {

  FerramentaDeNumeros f1 = new FerramentaDeNumeros();
  Execucao ex = new Execucao();

  int numeroInseridoPeloUsuario;
  int numeroGeradoAleatorio;
  int valorPagoPeloUsuario;
  int premioPelaAposta;
  String modalidadeDeJogo;
  String mensagemFinal;
  int premio;
  String tipoJogo;

  public int getPremio() {

    premio = valorPagoPeloUsuario
        * ((modalidadeDeJogo.equals("milhar")) ? 10000
            : (modalidadeDeJogo.equals("centena")) ? 1000 : (modalidadeDeJogo.equals("dezena")) ? 100 : 10);

    return premio;
  }

  // Contrutor
  CarrinhoDeAposta(int numeroInseridoPeloUsuario, String modalidadeDeJogo, int valorPagoPeloUsuario, String tipoJogo) {

    this.tipoJogo = tipoJogo;

    this.modalidadeDeJogo = modalidadeDeJogo;

    this.numeroInseridoPeloUsuario = numeroInseridoPeloUsuario;

    this.valorPagoPeloUsuario = valorPagoPeloUsuario;

  }

  @Override
  public String toString() {

    return "Numero apostado: " + numeroInseridoPeloUsuario
        + "\nEstilo de Jogo: " + modalidadeDeJogo
        + "\nValor pago: " + valorPagoPeloUsuario + "\n\n\nResultado: "
        + ex.desmembrar(f1.numeroAleatorioEmMilhar(), modalidadeDeJogo);
  }

  // public String PainelGeral() {

  // FerramentaDeNumeros f1 = new FerramentaDeNumeros();
  // Execucao ex = new Execucao();

  // // String mensagemVerjogos = "Numero apostado: " + numeroInseridoPeloUsuario
  // // + "\nEstilo de Jogo: " + modalidadeDeJogo + "\nValor pago: "
  // // + valorPagoPeloUsuario;

  // return mensagemGeral;
  // }

}