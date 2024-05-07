package jogo;

import jogo.excecoes.ExcecaoXadrez;
import tabuleiro.Posicao;

public class PosicaoXadrez {
    private Character coluna;
    private Integer linha;

    public PosicaoXadrez(Character coluna, Integer linha) {
        if( (coluna < 'a' || coluna > 'h') && 
            (linha < 1 || linha > 8)){
            throw new ExcecaoXadrez("Erro na instância: Posicao invalida. Deve ser entre a1 até h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    protected Posicao conversaoPosicao(){
        return new Posicao( 8 - this.linha, this.coluna - 'a');
    }
    
    protected static PosicaoXadrez conversaoPosicaoXadrez( Posicao posicao ){
        return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
    
    
    
    public Character getColuna() {
        return coluna;
    }

    public Integer getLinha() {
        return linha;
    }
}
