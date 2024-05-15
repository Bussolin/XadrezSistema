package jogo.pecas;

import jogo.Cor;
import static jogo.Cor.BRANCA;
import static jogo.Cor.PRETA;
import jogo.PartidaXadrez;
import jogo.PecaXadrez;
import jogo.excecoes.ExcecaoXadrez;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez{
    
    private PartidaXadrez jogo;
    
    public Peao(Cor cor, Tabuleiro tabuleiro, PartidaXadrez jogo) {
        super(cor, tabuleiro);
        this.jogo = jogo;
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
        if( tabuleiro.posicaoExiste( p ) && !getTabuleiro().existePecaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
            Posicao p2 = new Posicao( linha + incrementoDecremento, coluna );
            if( getContagemMovimento() == 0 && !getTabuleiro().existePecaNaPosicao( p2 ) ){
                matriz[ p2.getLinha() ][ p2.getColuna() ] = true;
            }
        }
        
        p.setColuna( coluna + 1);
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
        }
        p.setColuna( coluna - 1 );
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) ){
            matriz[ p.getLinha() ][ p.getColuna() ] = true;
        }
        
        //enPeassant
        p.setValores( linha - incrementoDecremento, coluna + 1);
        if( tabuleiro.posicaoExiste( p ) && tabuleiro.pecaTabuleiro( p ) != null && tabuleiro.pecaTabuleiro( p ) == jogo.getEnPasseantVulneravel() ){
            matriz[ p.getLinha() + incrementoDecremento ][ p.getColuna() ] = true;
        }
        
        p.setValores( linha - incrementoDecremento, coluna - 1);
        if( tabuleiro.posicaoExiste( p ) && pecaAdversariaNaPosicao( p ) && tabuleiro.pecaTabuleiro( p ) == jogo.getEnPasseantVulneravel() ){
            matriz[ p.getLinha() + incrementoDecremento ][ p.getColuna() ] = true;
        }
        
        return matriz;
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
