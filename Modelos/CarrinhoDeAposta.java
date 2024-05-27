package Modelos;

public class CarrinhoDeAposta {

    int numeroInseridoPeloUsuario;
    int numeroGeradoAleatorio;
    int valorPagoPeloUsuario;
    int premioPelaAposta;
    String modalidadeDeJogo;

    // Contrutor
    public CarrinhoDeAposta(int _numeroInseridoPeloUsuario, String _modalidadeDeJogo, int _valorPagoPeloUsuario) {
        
        this.modalidadeDeJogo = _modalidadeDeJogo;

        this.numeroInseridoPeloUsuario = _numeroInseridoPeloUsuario;

        this.valorPagoPeloUsuario = _valorPagoPeloUsuario;

    }

    public String getModalidadeDeJogo() {
        return modalidadeDeJogo;
    }

    public void setModalidadeDeJogo(String modalidadeDeJogo) {
        this.modalidadeDeJogo = modalidadeDeJogo;
    }

    public int getNumeroInseridoPeloUsuario() {
        return numeroInseridoPeloUsuario;
    }

    public void setNumeroInseridoPeloUsuario(int numeroInseridoPeloUsuario) {
        this.numeroInseridoPeloUsuario = numeroInseridoPeloUsuario;
    }

    public int getNumeroGeradoAleatorio() {
        return numeroGeradoAleatorio;
    }

    public void setNumeroGeradoAleatorio(int numeroSorteado) {
        this.numeroGeradoAleatorio = numeroSorteado;
    }

    public int getValorPagoPeloUsuario() {
        return valorPagoPeloUsuario;
    }

    public void setValorPagoPeloUsuario(int valorPagoPeloUsuario) {
        this.valorPagoPeloUsuario = valorPagoPeloUsuario;
    }

    public int getPremioPelaAposta() {
        return premioPelaAposta;
    }

    public void setPremioPelaAposta(int premioPelaAposta) {
        this.premioPelaAposta = premioPelaAposta;
    }

    @Override
    public String toString() {

        return "\n\nOque o usuario escolheu:  " + "    Estilo de Jogo: " + this.getModalidadeDeJogo()
                + "  Numero apostado: "
                + this.getNumeroInseridoPeloUsuario() + "  Valor pago na aposta: " + this.getValorPagoPeloUsuario()
                + "\n\n" + "Resultados: \n" + "\nNumero gerado aleatoromente: " + this.getNumeroGeradoAleatorio();
    }

}