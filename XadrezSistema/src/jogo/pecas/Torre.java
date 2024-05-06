package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez{
    
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "R";
    }
    
}
