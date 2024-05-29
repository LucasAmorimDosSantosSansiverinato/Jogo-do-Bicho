package Modelos;

public class CarrinhoDeAposta {

    int numeroInseridoPeloUsuario;
    int numeroGeradoAleatorio;
    int valorPagoPeloUsuario;
    int premioPelaAposta;
    String modalidadeDeJogo;

    // Contrutor
      CarrinhoDeAposta(int _numeroInseridoPeloUsuario, String _modalidadeDeJogo, int _valorPagoPeloUsuario) {
        
        this.modalidadeDeJogo = _modalidadeDeJogo;

        this.numeroInseridoPeloUsuario = _numeroInseridoPeloUsuario;

        this.valorPagoPeloUsuario = _valorPagoPeloUsuario;

    }

}