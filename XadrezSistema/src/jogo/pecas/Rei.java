package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    
    public Rei(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "K";
    }
    
    
    
}
