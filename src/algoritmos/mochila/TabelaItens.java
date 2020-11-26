package algoritmos.mochila;

import java.util.LinkedList;

public class TabelaItens extends Tabela<Item>{

    public TabelaItens(int maxX, int maxY) {
        super(maxX, maxY);
    }

    public float getValorDeAtual(){
        return ((float) getAtual().stream().mapToDouble(item -> item.valor).sum());
    }

    public int getPesoDeAtual(){
        return getAtual().stream().mapToInt(item -> item.peso).sum();
    }


    public float getUltimoValor(){
        return ((float) getUltimo().stream().mapToDouble(item -> item.valor).sum());
    }

    public float getAnteriorValor(boolean ehColuna){
        return ((float) getAnterior(ehColuna).stream().mapToDouble(item -> item.valor).sum());
    }

    public int getAtualPesoMax() {
        return getAtualPropiedades(true).get(0).peso;
    }

}
