package tabuleiro;

public class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca( Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.posicao = null;
    }
    
    /*
    public abstract Boolean[][] movimentosPossiveis();;
    
    public Boolean movimentoPossivel(Posicao pos){
        return movimentosPossiveis()[pos.getLinha()][pos.getColuna()];
    }
    
    public Boolean existeMovimentoPossivel(){
        for( Boolean[] arrayB : movimentosPossiveis()){
           for( Boolean b : arrayB){
               if( b ){
                   return true;
               }
           } 
        }
        return false;
    }
    */

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
   
    
}
