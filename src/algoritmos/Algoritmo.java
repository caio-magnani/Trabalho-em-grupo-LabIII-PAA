package algoritmos;

import java.util.LinkedList;

public interface Algoritmo<E>{

    LinkedList<E> preparationSet(int n);
    void algoritmo(LinkedList<E> dadosCriados, int n);
}