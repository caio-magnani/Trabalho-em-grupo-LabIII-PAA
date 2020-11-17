package algoritmos.mochila;

import algoritmos.Algoritmo;
import java.util.LinkedList;
import java.util.Random;

public class Mochila implements Algoritmo<Item> {
    public static int pesoMax;
    public static int valorMax;

    @Override
    public LinkedList<Item> preparationSet(int n) {
        LinkedList<Item> items =new LinkedList<Item>();
        for (int i = 0; i < n; i++){
            items.add(new Item(randomPeso(),randomValor()));
        }
        return items;
    }

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
    }

    private int randomPeso(){
        Random rand =new Random();
        int x = rand.nextInt(pesoMax);
        while (x==0 || x<0){
            x=rand.nextInt(pesoMax);
        }
        return x;
    }
    private int randomValor(){
        Random rand =new Random();
        int x = rand.nextInt(valorMax);
        while (x==0 || x<0){
            x=rand.nextInt(valorMax);
        }
        return x;
    }
}
