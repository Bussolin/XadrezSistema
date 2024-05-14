package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Bispo extends PecaXadrez {

    public Bispo(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        Posicao p = new Posicao( 0,0);
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();
        
        //diagonalEsquerdaAcima
        p.setValores( linha - 1, coluna - 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores( p.getLinha() - 1, p.getColuna() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //diagonalEsquerdaAbaixo
        p.setValores( linha + 1, coluna - 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores( linha + 1, coluna - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //diagonalDireitaAcima
        p.setValores( linha - 1, coluna + 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores( linha - 1, coluna + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //diagonalDireitaAbaixo
        p.setValores( linha + 1, coluna + 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna( p.getColuna() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        return matriz;
    }

    @Override
    public String toString() {
        return "B";
    }
    
    
    
}
