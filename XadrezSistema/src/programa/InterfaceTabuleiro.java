package programa;

import java.util.InputMismatchException;
import java.util.Scanner;
import jogo.Cor;
import jogo.PecaXadrez;
import jogo.PosicaoXadrez;

public class InterfaceTabuleiro {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static void imprimeTabuleiro( PecaXadrez[][] px ){
        for( int i = 0; i < px.length; i++ ){
            System.out.print( 8 - i + " " );
            for( int j = 0; j < px.length; j++ ){
                imprimePeca( px[ i ][ j ] );
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    public static void imprimePeca( PecaXadrez peca ){
        if (peca == null) {
            System.out.print("-");
        }
        else {
            if (peca.getCor()== Cor.BRANCA) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_BLACK + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
    
    public static PosicaoXadrez lerPosicao( Scanner scan ){
        try{
            String s = scan.nextLine();
            char coluna = s.charAt(0);
            Integer linha = Integer.valueOf( s.substring(1) );
            return new PosicaoXadrez( coluna, linha );
        }catch( RuntimeException e){
            throw new InputMismatchException("Erro ao ler posicao: valores validos sao de a1 ate h8");
        }
    }
    
}
