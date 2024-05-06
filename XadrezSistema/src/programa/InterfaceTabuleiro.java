package programa;

import jogo.PecaXadrez;

public class InterfaceTabuleiro {
    public static void imprimeTabuleiro( PecaXadrez[][] px ){
        for( int i = 0; i<px.length; i++){
            System.out.print(8 - i + " " );
            for( int j = 0; j<px.length; j++){
                imprimePeca( px[i][j] );
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    public static void imprimePeca( PecaXadrez peca ){
        if( peca == null){
            System.out.print("-");
        }else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
