package programa;

import java.util.Scanner;
import jogo.PartidaXadrez;
import jogo.PecaXadrez;
import jogo.PosicaoXadrez;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class main {
    
    public static void main(String[] args) {
        
        try{
            PartidaXadrez jogo = new PartidaXadrez();
            Scanner scan = new Scanner(System.in);
            String posicao;
            do{
                InterfaceTabuleiro.imprimeTabuleiro( jogo.getPecas() );
                System.out.println();
                System.out.println("Origem: ");
                PosicaoXadrez origem = InterfaceTabuleiro.lerPosicao(scan);
                
                System.out.println();
                System.out.println("Destino: ");
                PosicaoXadrez destino = InterfaceTabuleiro.lerPosicao(scan);
                
                PecaXadrez pecaCaputarada = jogo.movimentaPecaXadrez( origem, destino);
            }while( true );
            
        }catch(ExcecaoTabuleiro e){
            System.out.println(e.getMessage());
            for(  StackTraceElement s : e.getStackTrace()){
                System.out.println(s.toString() );
            }
        }
    }
    
}
