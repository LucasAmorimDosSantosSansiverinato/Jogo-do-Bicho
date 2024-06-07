package Usuario;


import Modelos.Menu;

public class CarteiraDoUsuario {

    public int carteira = 0;
    
    // Cobra o usuario
    public void debitarDaCarteira(int valor) {
        carteira = carteira -  valor;
        System.out.println("Saldo atual depois de pagar: " + carteira);
        
    }


    public void depositarSaldoNaConta (int valor ) {
        carteira = carteira +  valor;
        System.out.println( "Saldo atual depois de depositar: " + carteira );
    }

}
