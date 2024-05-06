package programa;

import jogo.PartidaXadrez;

public class main {
    
    public static void main(String[] args) {
        PartidaXadrez jogo = new PartidaXadrez();
        InterfaceTabuleiro.imprimeTabuleiro( jogo.getPecas() );
        
        
    }
   
    
    
}
