package algoritmos;

import java.util.LinkedList;

public interface Algoritmo<E>{

    LinkedList<E> preparationSet(int n);
    void resolver(LinkedList<E> dadosCriados, int n);
}
