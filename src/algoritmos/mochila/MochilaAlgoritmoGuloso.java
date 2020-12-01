package algoritmos.mochila;

import algoritmos.Algoritmo;

import java.util.Comparator;
import java.util.LinkedList;

public class MochilaAlgoritmoGuloso extends Mochila{

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
//        System.out.println("Capacidade da mochila = "+capacidade);
//        System.out.println("Com os dados abaixo \n"+dadosCriados.toString());
        dadosCriados.sort(Item::compareTo);
        while (capacidade<dadosCriados.stream().mapToInt(i->i.peso).sum()){
            dadosCriados.removeFirst();
        }
//        System.out.println("O Algusto Guloso rsrs \nAchou o valor de ="
//                +dadosCriados.stream().mapToDouble(i->i.valor).sum());
//        System.out.println("Peso da solução ="+dadosCriados.stream().mapToInt(i->i.peso).sum());
//        System.out.println("Melhor seguencia abaixo \n"+dadosCriados.toString());

    }
}
