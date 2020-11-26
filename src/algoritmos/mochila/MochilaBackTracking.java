package algoritmos.mochila;

import javax.swing.*;
import java.util.LinkedList;

public class MochilaBackTracking extends Mochila{
    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        LinkedList<Item>melhorCombinacao=new LinkedList<Item>();
        LinkedList<Item>combinacaoAtual=new LinkedList<Item>();
        Double melhorSoma=0D;
        int i=1;//em qual indice do array esta
        int j=1;//em qual opção esta
        combinacaoAtual.add(dadosCriados.get(0));
        do{

            int pesoAtual=combinacaoAtual.stream().mapToInt(p->p.peso).sum();
            if(capacidade < pesoAtual ){
                i--;
                j++;
                combinacaoAtual.remove();
            }
            else{
                Double somaAtual= combinacaoAtual.stream().mapToDouble(p->p.valor).sum();
                if(melhorSoma<somaAtual){
                    melhorCombinacao= (LinkedList<Item>) combinacaoAtual.clone();
                    melhorSoma= somaAtual;
                }
                if(combinacaoAtual.size()>n){
                    i--;
                    j++;
                    combinacaoAtual.remove();
                }
                combinacaoAtual.add(dadosCriados.get(j));
                j++;
                i++;

            }
        }
        while (combinacaoAtual.get(0)!=dadosCriados.get(n-1));

        System.out.println("Capacidade da mochila= "+capacidade);
        System.out.println("Todas as opções"+dadosCriados.toString());
        System.out.println("A melhor combinação: "+melhorCombinacao.toString());
        System.out.println("Com valor de: "+melhorSoma);
        System.out.println("E peso de: "+melhorCombinacao.stream().mapToInt(p->p.peso).sum());
    }
}
