import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Algoritmos {
    
//Preparações
    //exemplo de preparação
    public static List criandoLista(int n) {
        List<Integer> lista = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista;
    }



//Algoritmos

    //Bubble Sort Exemple
    public static List bubbleSort(List<Integer> lista, int n) throws IndexOutOfBoundsException {//complexidade O(n²)
        boolean trocado = false;
        for (int i = 1; i < n; i++) {
            if (lista.get(i - 1) > lista.get(i)) {
                trocado = true;
                int aux = lista.get(i - 1);
                lista.set(i - 1, lista.get(i));
                lista.set(i, aux);
            }
        }
        if (trocado) return bubbleSort(lista, n);
        else
            return lista;
    }

}
