package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez{
    
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        Posicao p = new Posicao( 0,0);
        
        //acima
        p.setValores( posicao.getLinha() - 1, posicao.getColuna() );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha( p.getLinha() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //abaixo
        p.setValores( posicao.getLinha() + 1, posicao.getColuna() );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha( p.getLinha() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //direita
        p.setValores( posicao.getLinha(), posicao.getColuna() + 1);
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna( p.getColuna() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        p.setValores( posicao.getLinha(), posicao.getColuna() - 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna( p.getColuna() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        return matriz;
    }
    
}
