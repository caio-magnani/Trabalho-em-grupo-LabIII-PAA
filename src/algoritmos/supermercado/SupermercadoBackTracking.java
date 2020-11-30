package algoritmos.supermercado;

import algoritmos.mochila.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SupermercadoBackTracking {
    public static LinkedList<Produto> preparationSet(int n) {
        LinkedList<Produto> productList = new LinkedList<Produto>();
        String[] products = {"Sabão","Shampoo", "Detergente", "Café", "Lasanha Congelada", "Refrigerante"};
        double[] preco = {4.00,6.19, 3.29,4.29,16.99,11.69};
        int[] peso = {1,2,2,3,7,5};

        for(int i = 0; i < products.length ; i++)
            productList.add(new Produto(preco[i], peso[i], products[i]));

        return productList;
    }

    public static void resolver(LinkedList<Produto> dadosCriados, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para prosseguirmos por favor insira o seu orçamento");
        double orcamentoMax = scanner.nextDouble();
        System.out.println("Para prosseguirmos por favor insira o peso Max");
        int pesoMax = scanner.nextInt();

        LinkedList<Produto> productList = dadosCriados;

        // BackTracking
        LinkedList<Produto>melhorCombinacao=new LinkedList<Produto>();
        LinkedList<Produto>combinacaoAtual=new LinkedList<Produto>();
        Double melhorSoma=0D;
        int i=1;//em qual indice do array esta
        int j=1;//em qual opção esta
        combinacaoAtual.add(productList.get(0));
        do{
            int pesoAtual=combinacaoAtual.stream().mapToInt(p->p.peso).sum();
            if(pesoMax < pesoAtual ){
                i--;
                j++;
                combinacaoAtual.remove();
            }
            else{
                Double somaAtual= combinacaoAtual.stream().mapToDouble(p->p.preco).sum();
                if(melhorSoma<somaAtual) {
                    melhorCombinacao = (LinkedList<Produto>) combinacaoAtual.clone();
                    melhorSoma = somaAtual;
                }
                if(combinacaoAtual.size()>n) {
                    i--;
                    j++;
                    combinacaoAtual.remove();
                }
                 combinacaoAtual.add(dadosCriados.get(j));
                j++;
                i++;
            }
        }
        while (combinacaoAtual.get(0)!=dadosCriados.get(n-1) && i != 6) ;

    }
}
