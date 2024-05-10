package jogo;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Cor cor;
    private int ContagemMovimento;

    public PecaXadrez(Cor cor, Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.cor = cor;
    }
    
    public Boolean pecaAdversariaNaPosicao( Posicao posicao ){
        PecaXadrez p = (PecaXadrez) getTabuleiro().pecaTabuleiro(posicao);
        return p != null && p.getCor() != this.cor;
    }
    
    public Boolean pecaAliadaNaPosicao( Posicao posicao ){
        PecaXadrez p = (PecaXadrez) getTabuleiro().pecaTabuleiro(posicao);
        return p != null && p.getCor() == this.cor;
    }

    public void aumentaContagem(){
        this.ContagemMovimento++;
    }
    
    public void diminuiContagem(){
        this.ContagemMovimento--;
    }
    
    public int getContagemMovimento() {
        return ContagemMovimento;
    }
    
    public PosicaoXadrez getPosicaoXadrez(){
        return PosicaoXadrez.conversaoPosicaoXadrez(posicao);
    }

    public Cor getCor() {
        return cor;
    }
    
}
