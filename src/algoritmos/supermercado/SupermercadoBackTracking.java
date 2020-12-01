package algoritmos.supermercado;

import algoritmos.Algoritmo;
import algoritmos.mochila.Item;

import java.util.*;

public class SupermercadoBackTracking implements Algoritmo<Produto> {
    public LinkedList<Produto> preparationSet(int n) {
        LinkedList<Produto> productList = new LinkedList<Produto>();
        String[] products = new String[n];
        double[] preco = new double[n];
        int[] peso = new int[n];
        Random random = new Random();

        for(int i = 0; i < products.length ; i++)
        {
            int numero = random.nextInt(100);
            double numeroDouble = random.nextDouble() * 100;
            productList.add(new Produto(numeroDouble, numero, "Product"+i+1));
        }

        return productList;
    }

    public void resolver(LinkedList<Produto> dadosCriados, int n) {
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
        int i=0;//em qual indice do array esta
        int j=0;//em qual opção esta
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
        while ((i < n && j < n )) ;

    }
}
