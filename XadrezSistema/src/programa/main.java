package programa;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;
import jogo.PartidaXadrez;
import jogo.PosicaoXadrez;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class main {
    
    public static void main(String[] args) {
        
        PartidaXadrez jogo = new PartidaXadrez();
        Scanner scan = new Scanner(System.in);
        do{
            try{
                InterfaceTabuleiro.clearScreen();
                InterfaceTabuleiro.imprimeJogo( jogo );
                System.out.print("Origem: ");
                PosicaoXadrez origem = InterfaceTabuleiro.lerPosicao(scan );

                boolean[][] possiveisMovimentos = jogo.possiveisMovimentos(origem);
                InterfaceTabuleiro.clearScreen();
                InterfaceTabuleiro.imprimeTabuleiro(jogo.getPecas(), possiveisMovimentos);
                
                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = InterfaceTabuleiro.lerPosicao(scan);

                jogo.movimentaPecaXadrez( origem, destino );
                
                if (jogo.getPromovido() != null){
                    System.out.println("Peca para promocao: (B/C/T/R)");
                    String tipoPeca = scan.nextLine();
                    jogo.trocaPecaPromovida( tipoPeca );
                }
            }catch( ExcecaoTabuleiro | InputMismatchException | IllegalStateException | InvalidParameterException e ){
                System.out.println(e.getMessage());
                System.out.println("Pressione ENTER para continuar");
                scan.nextLine();
                }
            }while( !jogo.isCheckmate() );
        InterfaceTabuleiro.clearScreen();
        InterfaceTabuleiro.imprimeJogo( jogo );
        }
}
