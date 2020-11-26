package algoritmos.mochila;

import java.util.LinkedList;

public class Tabela <T>{
    private LinkedList<T>[][] tabela;
    private int atualX;
    private int atualY;
    private int maxX;
    private int maxY;

    public Tabela(int maxX, int maxY) {
        this.tabela = new LinkedList[++maxX][++maxY];
        this.maxX = maxX;
        this.maxY = maxY;
        this.atualX=1;
        this.atualY=1;
        for(int x=0;x<maxX;x++){
            for (int y=0;y<maxY;y++){
                tabela[x][y]=new LinkedList<T>();
            }
        }
    }

    public LinkedList<T> getAtual(){
        return tabela[atualX][atualY];
    }

    public void next(){
        atualY++;
        if (atualY==maxY){
            atualY=1;
            atualX++;
        }
        if (atualX==maxX){
            System.out.println("Fim da Tabela");
            atualY=maxY-1;
        }
    }

    public LinkedList<T> getAnterior(boolean ehColuna){
        if(ehColuna)
            return getAnyOne(atualX,atualY-1);
        else
            return getAnyOne(atualX-1,atualY);
    }

    public LinkedList<T> getAtualPropiedades(boolean ehPesoMax){
        if(ehPesoMax)
            return tabela[0][atualY];
        else
            return tabela[atualX][0];
    }

    public int getIndiceLinha(){
        return atualX;
    }

    public LinkedList<T> getAnyOne(int x,int y){
        return tabela[x][y];
    }

    public LinkedList<T> getUltimo(){
        return getAnyOne(maxX-1,maxY-1);
    }
}
