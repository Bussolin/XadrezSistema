package programa;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import jogo.Cor;
import jogo.PartidaXadrez;
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
    
    public static void imprimeJogo( PartidaXadrez jogo ){
        imprimeTabuleiro( jogo.getPecas() );
        System.out.println();
        imprimePecasCapturadas( jogo.getCapturadas() );
        System.out.println();
        System.out.println("Turno: " + jogo.getTurno());
        System.out.println("Esperando " + jogo.getJogadorTurno() + " jogar");
    }
    
    public static void imprimeTabuleiro( PecaXadrez[][] px ){
        for( int i = 0; i < px.length; i++ ){
            System.out.print( 8 - i + " " );
            for( int j = 0; j < px.length; j++ ){
                imprimePeca( px[ i ][ j ], false );
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    public static void imprimeTabuleiro( PecaXadrez[][] px, boolean[][] movimentosPossiveis ){
        for( int i = 0; i < px.length; i++ ){
            System.out.print( 8 - i + " " );
            for( int j = 0; j < px.length; j++ ){
                imprimePeca( px[ i ][ j ],  movimentosPossiveis[i][j] );
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    public static void imprimePeca( PecaXadrez peca, boolean lancePossivel ){
        if( lancePossivel){
            System.out.print(ANSI_GREEN_BACKGROUND);
        }
        
        if (peca == null) {
            System.out.print("-" + ANSI_RESET );
        }
        else {
            switch(peca.getCor()){
                case Cor.BRANCA -> System.out.print(ANSI_WHITE + peca + ANSI_RESET);
                case Cor.PRETA -> System.out.print(ANSI_BLUE + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
    
    public static void imprimePecasCapturadas(List<PecaXadrez> capturadas){
        List<PecaXadrez> brancas = capturadas.stream().filter( x -> x.getCor() == Cor.BRANCA).collect(Collectors.toList());
        List<PecaXadrez> pretas = capturadas.stream().filter( x -> x.getCor() == Cor.PRETA).collect(Collectors.toList());

        
        System.out.println("Pecas capturadas:");
        
        System.out.print("Branca: ");
        System.out.print(ANSI_WHITE);
        System.out.print(Arrays.toString(brancas.toArray()));
        System.out.print(ANSI_RESET);
        System.out.println();
        
        
        System.out.print("Pretas: ");
        System.out.print(ANSI_BLUE);
        System.out.print(Arrays.toString(pretas.toArray()));
        System.out.print(ANSI_RESET);
        System.out.println();
        
        
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
    
    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
    
}
