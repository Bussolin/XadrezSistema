package tabuleiro;

import tabuleiro.excecoes.ExcecaoTabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas ) {
        if( linhas < 1 || colunas < 1){
            throw new ExcecaoTabuleiro("Impossivel um tabuleiro ter linha ou colunas menor que zero!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public void colocaPeca(Peca novaPeca, Posicao posicao){
        if( !posicaoExiste(posicao)){
            throw new ExcecaoTabuleiro("Posicao nao existe");
        }  
        if( existePecaNaPosicao(posicao) ){
            throw new ExcecaoTabuleiro("Ja existe peca nessa posicao");
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = novaPeca;
        novaPeca.posicao =  posicao;
    }
    
    public Boolean posicaoExiste(Posicao pos){
        return (pos.getLinha() >= linhas || pos.getLinha() < 0)
                && (pos.getColuna() >= colunas || pos.getColuna()< 0);
    }
    
    public Boolean existePecaNaPosicao( Posicao posicao ){
        return pecaTabuleiro(posicao) != null;
    }
    
    public Peca pecaTabuleiro( Integer linha, Integer coluna){
        return pecas[linha][coluna];
    }
    
    public Peca pecaTabuleiro( Posicao pos){
        return pecas[pos.getLinha()][pos.getColuna()];
    }
    
    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }
    
    
    
}
