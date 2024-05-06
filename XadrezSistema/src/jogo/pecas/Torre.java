/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.pecas;

import jogo.Cor;
import jogo.PecaXadrez;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Ingadev
 */
public class Torre extends PecaXadrez{
    
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "R";
    }
    
}
