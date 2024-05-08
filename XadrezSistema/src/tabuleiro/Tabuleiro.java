package tabuleiro;

import tabuleiro.excecoes.ExcecaoTabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas ) {
        if( linhas < 1 || colunas < 1){
            throw new ExcecaoTabuleiro("Erro Tabuleiro: necessário ter linhas e/ou colunas maior que zero!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public Peca removePeca( Posicao pos ){
        if( existePecaNaPosicao( pos ) ){
            Peca p = pecaTabuleiro( pos );
            p.posicao = null;
            pecas[ pos.getLinha() ][ pos.getColuna() ] = null;
            return p;
        }
        return null;
    }
    
    public void colocaPeca(Peca novaPeca, Posicao posicao){
        if( existePecaNaPosicao( posicao ) ){
            throw new ExcecaoTabuleiro("Erro Tabuleiro: Ja existe peca nessa posicao");
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = novaPeca;
        novaPeca.posicao =  posicao;
    }
    public Peca pecaTabuleiro( Integer linha, Integer coluna){    
        if( !posicaoExiste(linha, coluna)){
            throw new ExcecaoTabuleiro("Erro Tabuleiro: Posicao nao existe");
        }
        return pecas[linha][coluna];
    }
    
    public Peca pecaTabuleiro( Posicao pos){
        if( !posicaoExiste(pos)){
            throw new ExcecaoTabuleiro("Erro Tabuleiro: Posicao nao existe");
        }
        return pecas[pos.getLinha()][pos.getColuna()];
    }
    
    public Boolean posicaoExiste(Posicao pos){
        return posicaoExiste(pos.getLinha(), pos.getColuna() );
    }
    
    public Boolean posicaoExiste(int linha, int coluna){
        return linha < linhas && linha >= 0 && coluna < colunas && coluna >= 0;
    }
    
    public Boolean existePecaNaPosicao( Posicao posicao ){
        if( !posicaoExiste(posicao)){
            throw new ExcecaoTabuleiro("Erro Tabuleiro: Posicao nao existe");
        }
        return pecaTabuleiro(posicao) != null;
    }
    
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
