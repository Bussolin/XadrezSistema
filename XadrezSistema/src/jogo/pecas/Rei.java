package jogo.pecas;

import jogo.Cor;
import jogo.PartidaXadrez;
import jogo.PecaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    
    private PartidaXadrez jogo;
    
    public Rei(Cor cor, Tabuleiro tabuleiro, PartidaXadrez jogo) {
        super(cor, tabuleiro);
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean testeRoque(Posicao pos){
        PecaXadrez p = (PecaXadrez)getTabuleiro().pecaTabuleiro(pos);
        return p != null && p instanceof Torre && p.getContagemMovimento() == 0;
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getColunas()][tabuleiro.getLinhas()];
        
        for( Integer i = 0; i<tabuleiro.getLinhas();i++){
            if( i.equals(this.posicao.getLinha() + 1 ) || i.equals(this.posicao.getLinha() - 1 ) || i.equals(this.posicao.getLinha()) ){
                for( Integer j = 0; j < tabuleiro.getColunas(); j++){
                    matriz[i][j] = ( (j.equals(this.posicao.getColuna() + 1)) || (j.equals(this.posicao.getColuna() - 1)) || 
                                     (j.equals(this.posicao.getColuna()) && !i.equals(this.posicao.getLinha()) ))
                                   && tabuleiro.posicaoExiste( i, j ) && !pecaAliadaNaPosicao( new Posicao(i, j));
                }
            }
        }
        if(getContagemMovimento() == 0 && !jogo.isCheck() ){
            //roque pequeno
            Posicao posTorre = new Posicao( posicao.getLinha(), posicao.getColuna() + 3);
            if(testeRoque(posTorre)){
                Posicao p1 = new Posicao(  posicao.getLinha(), posicao.getColuna() + 2);
                Posicao p2 = new Posicao(  posicao.getLinha(), posicao.getColuna() + 1);
                if( getTabuleiro().pecaTabuleiro(p1) == null && getTabuleiro().pecaTabuleiro(p2 ) == null){
                    matriz[posicao.getLinha()][posicao.getColuna() + 2] = true;
                }
            }
            //roque grande
            posTorre = new Posicao( posicao.getLinha(), posicao.getColuna() - 4);
            if(testeRoque(posTorre)){
                Posicao p1 = new Posicao(  posicao.getLinha(), posicao.getColuna() - 3);
                Posicao p2 = new Posicao(  posicao.getLinha(), posicao.getColuna() - 2);
                Posicao p3 = new Posicao(  posicao.getLinha(), posicao.getColuna() - 1);
                if( getTabuleiro().pecaTabuleiro(p1) == null && getTabuleiro().pecaTabuleiro(p2 ) == null && getTabuleiro().pecaTabuleiro(p3 ) == null){
                    matriz[posicao.getLinha()][posicao.getColuna() - 2] = true;
                }
            }
        }
        return matriz;
    }    
}
