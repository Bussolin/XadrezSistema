package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez {

    public Cavalo(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        int coluna = posicao.getColuna();
        int linha = posicao.getLinha();
        Posicao p = new Posicao( 0, 0);
        if( coluna >= 2 ){
            //direita cima/baixo
            p.setValores( linha - 1, coluna - 2);
            if( linha != 0 && !pecaAliadaNaPosicao( p )){
                matriz[ linha - 1 ][ coluna - 2] = true;
            }
            p.setLinha(linha + 1);
            if( linha != 7 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha + 1 ][ coluna - 2] = true; 
            }
        }
        if( coluna <= 5 ){
            // esquerda cima/baixo
            p.setValores( linha - 1, coluna + 2);
            if( linha != 0 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha - 1 ][ coluna + 2] = true;
            }
            p.setLinha( linha + 1);
            if( linha != 7 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha + 1 ][ coluna + 2] = true; 
            }
        }
        if( linha >= 2 ){
            //abaixo esquerda/direita
            p.setValores( linha - 2, coluna - 1);
            if( coluna != 0 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha - 2 ][ coluna - 1] = true;
            }
            p.setColuna(coluna + 1 );
            if( coluna != 7 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha - 2 ][ coluna + 1] = true;
            }
        }
        if( linha <= 5){
            //acima esquerda/direita
            p.setValores( linha + 2, coluna - 1 );
            if( coluna != 0 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha + 2 ][ coluna - 1] = true;
            }
            p.setColuna(coluna + 1);
            if( coluna != 7 && !pecaAliadaNaPosicao( p ) ){
                matriz[ linha + 2 ][ coluna + 1] = true;
            }
        }
        return matriz;
    }

    @Override
    public String toString() {
        return "C";
    }
}
