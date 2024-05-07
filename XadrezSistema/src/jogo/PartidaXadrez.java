package jogo;

import jogo.excecoes.ExcecaoXadrez;
import jogo.pecas.Torre;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        organizacaoInicial();
    }
    
    public final void organizacaoInicial(){
        colocaNovaPeca('a', 1 ,new Torre(Cor.BRANCA, tabuleiro) );
        colocaNovaPeca('h', 1 ,new Torre(Cor.BRANCA, tabuleiro) );
        colocaNovaPeca('a', 8 ,new Torre(Cor.PRETA, tabuleiro) );
        colocaNovaPeca('h', 8 ,new Torre(Cor.PRETA, tabuleiro) );
    }
    
    public PecaXadrez movimentaPecaXadrez( PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.conversaoPosicao();
        Posicao destino = posicaoDestino.conversaoPosicao();
        validaPosicaoOrigem( posicaoOrigem.conversaoPosicao() );
        Peca pecaCapturada = fazMovimento( origem, destino );
        
        return (PecaXadrez) pecaCapturada;
    }
    
    private Peca fazMovimento( Posicao origem, Posicao destino){
        Peca p = tabuleiro.removePeca(origem);
        Peca capturada = tabuleiro.removePeca(destino);
        tabuleiro.colocaPeca(p, destino);
        return capturada;
    }
    
    private void validaPosicaoOrigem( Posicao origem ){
        if( !tabuleiro.existePecaNaPosicao(origem ) ){
            throw new ExcecaoTabuleiro("Nao existe peca na posicao de origem");
        }
    }
    
    private void colocaNovaPeca( char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).conversaoPosicao() );
    }
    
    public PecaXadrez[][] getPecas(){
       PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
       for( int i = 0; i<tabuleiro.getLinhas();i++){
           for( int j = 0; j<tabuleiro.getColunas();j++){
               matriz[i][j] = (PecaXadrez) tabuleiro.pecaTabuleiro(i, j);
           }
       }
       return matriz;
    }
    
}
