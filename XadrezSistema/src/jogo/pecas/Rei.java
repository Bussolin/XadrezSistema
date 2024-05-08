package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    
    public Rei(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getColunas()][tabuleiro.getLinhas()];
        
        for( Integer i = 0; i<8;i++){
            if( i.equals(this.posicao.getLinha() + 1 ) || i.equals(this.posicao.getLinha() - 1 ) || i.equals(this.posicao.getLinha()) ){
                for( Integer j = 0; j < 8; j++){
                        matriz[i][j] = ( (j.equals(this.posicao.getColuna() + 1)) || (j.equals(this.posicao.getColuna() - 1)) || 
                                         (j.equals(this.posicao.getColuna()) && !i.equals(this.posicao.getLinha()) ))
                                       && tabuleiro.posicaoExiste( i, j ); 
                }
            }
        }
        return matriz;
    }    
}
