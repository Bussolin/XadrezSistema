package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Rainha extends PecaXadrez{

    public Rainha(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        Posicao p = new Posicao( 0,0);
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();
        
       
        //acima
        p.setValores( linha - 1, coluna );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha( p.getLinha() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //abaixo
        p.setValores( linha + 1, coluna );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha( p.getLinha() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //direita
        p.setValores( linha, coluna + 1);
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna( p.getColuna() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        p.setValores( linha, coluna - 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna( p.getColuna() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
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
            p.setValores( p.getLinha() + 1, p.getColuna() - 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        //diagonalDireitaAcima
        p.setValores( linha - 1, coluna + 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores( p.getLinha() - 1, p.getColuna() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        //diagonalDireitaAbaixo
        p.setValores( linha + 1, coluna + 1 );
        while( tabuleiro.posicaoExiste( p ) && !tabuleiro.existePecaNaPosicao( p )){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores( p.getLinha() + 1, p.getColuna() + 1 );
        }
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        return matriz;
    }

    @Override
    public String toString() {
        return "R";
    }
}
