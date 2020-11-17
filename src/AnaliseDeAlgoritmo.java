import algoritmos.Algoritmo;
import algoritmos.mochila.Item;
import algoritmos.mochila.Mochila;
import algoritmos.mochila.MochilaForcaBruta;

import java.util.LinkedList;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao = 1;
    public static int n =5;       //tamanho de dado
    public static void main(String[] args) {
        LinkedList<Item> itens=new LinkedList<Item>();
        itens.add(new Item(2,20));
        itens.add(new Item(2,20));
        itens.add(new Item(2,20));
        itens.add(new Item(2,20));
        itens.add(new Item(10,10));
        Mochila algoritmo= new MochilaForcaBruta(10,20);
        algoritmo.resolver(itens,n);
    }

    public static float AnaliseDeAlgoritmo(Algoritmo algoritmo, int vezesDeRepeticao, int n){
        for (int i=0;i<vezesDeRepeticao;i++){
            //Preparação
            LinkedList dadosAlearórios=algoritmo.preparationSet(n);
            TimerCatcher.setInicioDaOperacao();
            //Algoritmo
            algoritmo.resolver(dadosAlearórios,n);
            TimerCatcher.setFimDaOperacao();
            TimerCatcher.tempoDeExecucaoDaOperacao();
        }
        return TimerCatcher.tempoDeExecucaoMedia();
    }
}
