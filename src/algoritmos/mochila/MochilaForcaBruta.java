package algoritmos.mochila;

import java.util.LinkedList;

public class MochilaForcaBruta extends Mochila{
    public MochilaForcaBruta(int pesoMax,int valorMax) {
        this.pesoMax=pesoMax;
        this.valorMax=valorMax;
    }

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        LinkedList<Item> resposta=dadosCriados;
        LinkedList<Item> possiveis=new LinkedList<Item>[];

    }
}
