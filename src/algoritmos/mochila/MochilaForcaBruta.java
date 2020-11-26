package algoritmos.mochila;

import java.util.LinkedList;

public class MochilaForcaBruta extends Mochila{

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        LinkedList<Item> melhorCombinacao=new LinkedList<Item>();
        Double melhorSoma=0D;
        LinkedList<Item>[] local = new LinkedList[n];
        for (int i=0;i<n;i++) {
            local[i] = new LinkedList<Item>();
            for (int j = 0; j < n; j++) {
                local[i].add(dadosCriados.get(j));
                Double localSoma=local[i].stream().mapToDouble(p->p.valor).sum();
                Integer localPeso=local[i].stream().mapToInt(p->p.peso).sum();
                if(melhorSoma<localSoma && capacidade>=localPeso){
                    melhorCombinacao= (LinkedList<Item>) local[i].clone();
                    melhorSoma=localSoma;
                }
            }
        }
        while (local[n-1].size()!=n)
        for (int i=0;i<n;i++){
            if(i+1!=n){
            local[i].add(dadosCriados.get(i+1));
            Double localSoma=local[i].stream().mapToDouble(p->p.valor).sum();
            Integer localPeso=local[i].stream().mapToInt(p->p.peso).sum();
                if(melhorSoma<localSoma && capacidade>=localPeso){
                    melhorCombinacao= (LinkedList<Item>) local[i].clone();
                    melhorSoma=localSoma;
                }
            }
        }
        System.out.println("Capacidade da mochila= "+capacidade);
        System.out.println("A melhor combinação: "+melhorCombinacao.toString());
        System.out.println("Com valor de: "+melhorSoma);
        System.out.println("E peso de: "+melhorCombinacao.stream().mapToInt(p->p.peso).sum());
    }

}
