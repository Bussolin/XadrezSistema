package tabuleiro;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca( Tabuleiro tabuleiro ) {
        this.tabuleiro = tabuleiro;
        this.posicao = null;
    }
    
    public abstract boolean[][] movimentosPossiveis();
    
    public boolean movimentoPossivel(Posicao pos){
        return movimentosPossiveis()[pos.getLinha()][pos.getColuna()];
    }
    
    public boolean existeMovimentoPossivel(){
        for( boolean[] arrayB : movimentosPossiveis()){
            for( Boolean b : arrayB){
                if( b ){
                   return true;
               }
           } 
        }
        return false;
    }

    @Override
    public String toString() {
        return "Peca{" + "posicao=" + posicao + ", tabuleiro=" + tabuleiro + '}';
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
   
    
}
