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
        Integer incrementoDecremento = incrementoDecremento( getCor() );
        int linha = this.posicao.getLinha() + incrementoDecremento;
        int coluna = this.posicao.getColuna();
        
        Posicao p = new Posicao( linha, coluna );
        if( !getTabuleiro().existePecaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
        }
        Posicao p2 = new Posicao( posicao.getLinha() + incrementoDecremento + incrementoDecremento, posicao.getColuna() );
        if( getContagemMovimento() == 0 && !getTabuleiro().existePecaNaPosicao( p ) && !getTabuleiro().existePecaNaPosicao( p2 ) ){
            matriz[ p2.getLinha() ][ p2.getColuna() ] = true;
        }
        p.setColuna( coluna + 1);
        if( pecaAdversariaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
        }
        p.setColuna( coluna - 1 );
        if( pecaAdversariaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
        }
        
        
        return matriz;
    }
    
    private int posicaoInicial( Cor cor ){
        int posicaoInicial = 0;
        
        switch(cor){
            case BRANCA -> posicaoInicial = 6;
            case PRETA -> posicaoInicial = 1;
            default -> throw new ExcecaoXadrez("Cor da peca invalida verificar");
        }
        
        return posicaoInicial;
    }
    private int incrementoDecremento( Cor cor ){
        int incrementoDecremento = 0;
        
        switch(cor){
            case BRANCA -> incrementoDecremento = -1;
            case PRETA -> incrementoDecremento = 1;
            default -> throw new ExcecaoXadrez("Cor da peca invalida verificar");
        }
        
        return incrementoDecremento;
    }
}
