package programa;

import jogo.PartidaXadrez;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class main {
    
    public static void main(String[] args) {
        
        try{
            PartidaXadrez jogo = new PartidaXadrez();
            InterfaceTabuleiro.imprimeTabuleiro( jogo.getPecas() );
        }catch(ExcecaoTabuleiro e){
            System.out.println(e.getMessage());
            for(  StackTraceElement s : e.getStackTrace()){
                System.out.println(s.toString() );
            }
        }
        
        
        
    }
   
    
    
}
