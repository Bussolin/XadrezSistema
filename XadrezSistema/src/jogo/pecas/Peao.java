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
                
        if( this.getContagemMovimento() == 0 ){
            Integer posicaoInicial = posicaoInicial( getCor() );
            matriz[ posicaoInicial + incrementoDecremento ][ this.posicao.getColuna()] = true;
            matriz[ posicaoInicial + incrementoDecremento + incrementoDecremento ][ this.posicao.getColuna() ] = true;
        }else{
            int linha = this.posicao.getLinha();
            int coluna = this.posicao.getColuna();
            if( pecaAdversariaNaPosicao( new Posicao(linha + incrementoDecremento , coluna + 1) ) ){
                matriz[ linha + incrementoDecremento ][ coluna + 1 ] = true;
            }
            if( pecaAdversariaNaPosicao( new Posicao(linha + incrementoDecremento , coluna - 1) )){
                matriz[ linha + incrementoDecremento ][ coluna - 1 ] = true;
            }
            if( !pecaNaPosicao( new Posicao(this.posicao.getLinha() + incrementoDecremento , this.posicao.getColuna()) ) ){
                matriz[ this.posicao.getLinha() + incrementoDecremento( getCor() ) ][ this.posicao.getColuna()] = true;
            }
            
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
