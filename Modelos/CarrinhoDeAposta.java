package Modelos;

public class CarrinhoDeAposta {

  int numeroInseridoPeloUsuario;
  int numeroGeradoAleatorio;
  int valorPagoPeloUsuario;
  int premioPelaAposta;
  String modalidadeDeJogo;

  // Contrutor
  CarrinhoDeAposta(int numeroInseridoPeloUsuario, String modalidadeDeJogo, int valorPagoPeloUsuario,
      int numeroGeradoAleatorio) {

    this.modalidadeDeJogo = modalidadeDeJogo;

    this.numeroInseridoPeloUsuario = numeroInseridoPeloUsuario;

    this.valorPagoPeloUsuario = valorPagoPeloUsuario;

    this.numeroGeradoAleatorio = numeroGeradoAleatorio;

  }

}