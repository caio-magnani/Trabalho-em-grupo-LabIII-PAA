package algoritmos.mochila;

import algoritmos.Algoritmo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Mochila implements Algoritmo<Item> {
    protected static int capacidade;
    protected static final float PROPORCAOCAPACIDADE = 6.5f;
    @Override
    public LinkedList<Item> preparationSet(int n) {
        LinkedList<Item> prod = new LinkedList<Item>();
        for(int i=0; i<n; i++){
            Item novo = new Item();
            prod.add(novo);
        }
        capacidade=criarCapacidade(prod,PROPORCAOCAPACIDADE);
        return prod;
    }

    static int criarCapacidade(List<Item> lista, float proporcao){
        int pesoTotal = lista.stream().mapToInt(p -> p.peso).sum();
        int quantTotal = lista.size();
        float media = (float)pesoTotal/quantTotal;

        return (int)Math.ceil(media * proporcao);
    }
}
