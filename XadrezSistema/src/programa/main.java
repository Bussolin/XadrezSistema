package programa;

import java.util.InputMismatchException;
import java.util.Scanner;
import jogo.PartidaXadrez;
import jogo.PecaXadrez;
import jogo.PosicaoXadrez;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class main {
    
    public static void main(String[] args) {
        
       
        PartidaXadrez jogo = new PartidaXadrez();
        Scanner scan = new Scanner(System.in);
        do{
            try{
                InterfaceTabuleiro.clearScreen();
                InterfaceTabuleiro.imprimeTabuleiro( jogo.getPecas() );
                System.out.println();
                System.out.println("Origem: ");
                PosicaoXadrez origem = InterfaceTabuleiro.lerPosicao(scan);

                System.out.println();
                System.out.println("Destino: ");
                PosicaoXadrez destino = InterfaceTabuleiro.lerPosicao(scan);

                PecaXadrez pecaCaputarada = jogo.movimentaPecaXadrez( origem, destino);
            }catch(ExcecaoTabuleiro e){
                System.out.println(e.getMessage());
                System.out.println("Pressione ENTER para continuar");
                scan.nextLine();
                /*for(  StackTraceElement s : e.getStackTrace()){
                    System.out.println(s.toString() );
                    }*/
                }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                System.out.println("Pressione ENTER para continuar");
                scan.nextLine();
                
                }
            }while( true );
        }
}
