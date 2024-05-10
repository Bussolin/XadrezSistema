package jogo.pecas;

import jogo.Cor;
import static jogo.Cor.BRANCA;
import static jogo.Cor.PRETA;
import jogo.PecaXadrez;
import jogo.excecoes.ExcecaoXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez{

    public Peao(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "P";
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] matriz = new boolean[tabuleiro.getColunas()][tabuleiro.getLinhas()];
        
        for( Integer i = Inicializao( getCor() ); condicao( getCor(), i, tabuleiro ); iterador( i, getCor() )){
            System.out.println(i);
            for( Integer j = 0; j<tabuleiro.getColunas(); j++){
                System.out.println(j);
                if( i == this.posicao.getLinha()){
                    if( j == this.posicao.getColuna() && !pecaAdversariaNaPosicao(new Posicao(i, j)) ){
                        matriz[i][j] = true;
                    }else if( (j == this.posicao.getColuna() + 1 || j == this.posicao.getColuna() - 1) 
                            && pecaAdversariaNaPosicao(new Posicao(i, j)) ){
                        matriz[i][j] = true;
                    }
                }
                
            }
        }
        
        return matriz;
    }
    
    private int Inicializao( Cor cor ){
        int j = 0;
        switch( cor ){
            case BRANCA -> j = 7;
            case PRETA -> j = 0;
            default -> throw new ExcecaoXadrez("Peca com nenhuma cor. Verificar");
        }
        return j;
    }
    
    private boolean condicao( Cor cor, Integer coluna, Tabuleiro tabuleiro){
        boolean condicao;
        switch( cor ){
            case BRANCA -> condicao = coluna>= 0;
            case PRETA -> condicao = coluna<tabuleiro.getLinhas();
            default -> throw new ExcecaoXadrez("Peca com nenhuma cor. Verificar");
        }
        return condicao;
    }
        
    private int iterador( Integer linha, Cor cor ){
        switch(cor){
            case BRANCA -> linha--;
            case PRETA -> linha++;
            default -> throw new ExcecaoXadrez("Peca com nenhuma cor. Verificar");
        }
        return linha;
    }       
}
