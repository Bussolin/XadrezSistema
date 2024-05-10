package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jogo.excecoes.ExcecaoXadrez;
import jogo.pecas.Rei;
import jogo.pecas.Torre;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.excecoes.ExcecaoTabuleiro;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;
    private int turno = 1;
    private Cor jogadorTurno;
    private boolean check;
    
    private List<PecaXadrez> capturadas = new ArrayList<>();
    private List<PecaXadrez> pecasNoTabuleiro = new ArrayList<>();

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        jogadorTurno = Cor.BRANCA;
        organizacaoInicial();
    }
    
    public final void organizacaoInicial(){
        colocaNovaPeca('a', 1 ,new Torre(Cor.BRANCA, tabuleiro) );
        colocaNovaPeca('h', 1 ,new Torre(Cor.BRANCA, tabuleiro) );
        colocaNovaPeca('f', 1 ,new Rei( Cor.BRANCA, tabuleiro ) );
        colocaNovaPeca('e', 8 ,new Rei( Cor.PRETA, tabuleiro ) );
        colocaNovaPeca('a', 8 ,new Torre(Cor.PRETA, tabuleiro) );
        colocaNovaPeca('b', 8 ,new Torre(Cor.PRETA, tabuleiro) );
        colocaNovaPeca('a', 7 ,new Torre(Cor.PRETA, tabuleiro) );
        colocaNovaPeca('h', 8 ,new Torre(Cor.PRETA, tabuleiro) );
        
    }
    
    private void proximoTurno(){
        switch( this.jogadorTurno ){
            case BRANCA -> jogadorTurno = Cor.PRETA;
            case PRETA -> jogadorTurno = Cor.BRANCA;
        }
        if( jogadorTurno == Cor.BRANCA ){
            turno++;
        }
    } 
    
    private Cor corOponente( Cor cor ){
        return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }
    
    public boolean verificaCheck(Cor cor){
        List<PecaXadrez> pecasOponentes = pecasNoTabuleiro.stream().filter( x -> x.getCor() == corOponente( cor )).collect(Collectors.toList());
        Posicao posicaoRei = rei( cor ).getPosicaoXadrez().conversaoPosicao();
        for( PecaXadrez p : pecasOponentes ){
            if( p.movimentoPossivel( posicaoRei ) ){
                return true;
            }
        }
        return false;
    }
    
    private PecaXadrez rei( Cor cor ){
        List<PecaXadrez> rei = pecasNoTabuleiro.stream().filter( x-> x.getCor() == cor ).collect(Collectors.toList());
        for( PecaXadrez p : rei){
            if( p instanceof Rei){
                return p;
            }
        }
        throw new IllegalStateException("Nao existe rei da cor " + cor + " no tabuleiro. Verificar");
    }
    
    public boolean[][] possiveisMovimentos( PosicaoXadrez origem ){
        Posicao posicao = origem.conversaoPosicao();
        validaPosicaoOrigem( posicao, getJogadorTurno() );
        return tabuleiro.pecaTabuleiro(posicao).movimentosPossiveis();
    }
    
    public void movimentaPecaXadrez( PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.conversaoPosicao();
        Posicao destino = posicaoDestino.conversaoPosicao();
        validaPosicaoOrigem( posicaoOrigem.conversaoPosicao(), getJogadorTurno() );
        validaPosicaoDestino( posicaoOrigem.conversaoPosicao(), posicaoDestino.conversaoPosicao() );
        PecaXadrez pecaCapturada = (PecaXadrez) fazMovimento( origem, destino );
        
        if( pecaCapturada != null ){
            capturadas.add( pecaCapturada );
            pecasNoTabuleiro.remove( pecaCapturada );
        }
        
        if(verificaCheck(jogadorTurno)){
            desfazMovimento(origem, destino, pecaCapturada);
            throw new ExcecaoXadrez("Jogada invalida: o rei esta em check");
        }
        check = verificaCheck(corOponente(jogadorTurno));
        
        proximoTurno();
    }
    
    private Peca fazMovimento( Posicao origem, Posicao destino){
        Peca p = tabuleiro.removePeca(origem);
        Peca capturada = tabuleiro.removePeca(destino);
        tabuleiro.colocaPeca(p, destino);
        return capturada;
    }
    
    private void desfazMovimento( Posicao origem, Posicao destino, PecaXadrez capturada){
        Peca p = tabuleiro.removePeca(destino);
        tabuleiro.colocaPeca( p, origem );
        
        if( capturada != null ){
            tabuleiro.colocaPeca(capturada, destino);
            capturadas.remove( capturada );
            pecasNoTabuleiro.add( capturada );
        }
    }
    
    private void validaPosicaoOrigem( Posicao origem, Cor jogadorAtual ){
        if( !tabuleiro.existePecaNaPosicao(origem ) ){
            throw new ExcecaoTabuleiro("Nao existe peca na posicao de origem");
        }
        if( getJogadorTurno() != ((PecaXadrez) tabuleiro.pecaTabuleiro(origem)).getCor()){
            throw new ExcecaoXadrez("Peca nao pertence ao jogador");
        }
        if( !tabuleiro.pecaTabuleiro(origem).existeMovimentoPossivel()){
            throw new ExcecaoXadrez("Nao existe movimentos possiveis para a peca");
        }
    }
    
    private void validaPosicaoDestino( Posicao origem, Posicao destino ){
        if( !tabuleiro.pecaTabuleiro(origem).movimentoPossivel(destino)){
            throw new ExcecaoXadrez("Nao e um momento possivel da peca");
        }
    }
    
    private void colocaNovaPeca( char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).conversaoPosicao() );
        pecasNoTabuleiro.add( peca );
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
    
    public int getTurno() {
        return turno;
    }

    public Cor getJogadorTurno() {
        return jogadorTurno;
    }

    public boolean isCheck() {
        return check;
    }
    
    public List<PecaXadrez> getCapturadas() {
        return capturadas;
    }

    public List<PecaXadrez> getPecasNoTabuleiro() {
        return pecasNoTabuleiro;
    }
}
