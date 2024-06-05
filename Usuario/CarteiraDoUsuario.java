package Usuario;


import Modelos.Menu;

public class CarteiraDoUsuario {

    public int carteira;

    public int valorDoTicket = 0;

    public int getValorDoTicket() {
        return valorDoTicket;
    }

    public void setValorDoTicket(int valorDoTicket) {
        this.valorDoTicket = valorDoTicket;
    }

    public int getCarteira() {
        return carteira;
    }

    public void setCarteira(int carteira) {
        this.carteira = carteira;
    }

    // Cobra o usuario
    public int debitarDaCarteira(int getCarteira, int getValorDoTicket) {

        carteira -= getValorDoTicket;

        System.out.println("Saldo depois de pagar para jogar: " + carteira);

        return carteira;

    }

    // paga o usuario
    public int depositarPremioNaCarteira(int premio) {

        carteira += premio;

        System.out.println("Saldo depois do premio: " + carteira);

        return 0;
    }

    // usuario realiza deposito
    public void alterarSaldo(int valor) {
        carteira = +valor;
        System.out.println("Saldo depois do deposito: " + getCarteira());
    }

    public void depositarSaldoNaConta() {

        int valorDepositado = Menu.depositar(carteira); // passa o saldo atual da carteira
        alterarSaldo(valorDepositado);
    }

}
