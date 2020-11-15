package algoritmos.supermercado;

import algoritmos.Algoritmo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlgoritimoSupermercado implements Algoritmo<Produto>
{
    public LinkedList<Produto> preparationSet(int n) {
        LinkedList<Produto> productList = new LinkedList<Produto>();
        String[] products = {"Sabão","Shampoo", "Detergente", "Café", "Lasanha Congelada", "Refrigerante"};
        double[] preco = {4.00,6.19, 3.29,4.29,16.99,11.69};
        int[] peso = {1,2,2,3,7,5};

        for(int i = 0; i < products.length ; i++)
        {
            productList.add(new Produto(preco[i], peso[i], products[i]));
        }

        return productList;
    }

    public void algoritmo(LinkedList<Produto> dadosCriados, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para prosseguirmos por favor insira o seu orçamento");
        double orcamentoMax = scanner.nextDouble();
        System.out.println("Para prosseguirmos por favor insira o peso Max");
        int pesoMax = scanner.nextInt();

        LinkedList<Produto> productList = dadosCriados;

        // FORÇA BRUTA
        boolean next = true;
        double orcamentoIncremental = 0;
        int pesoIncremental = 0;
        List<Produto> disponivel = new ArrayList<Produto>();

        for(int i=0; i < productList.size(); i++)
            for(int j=0; j < productList.size(); j++) {
                if(i == j)
                    continue;

                double aux1 = orcamentoIncremental + productList.get(i).preco + productList.get(j).preco;
                int aux2 = pesoIncremental + productList.get(i).peso + productList.get(j).peso;
                if(aux1 > orcamentoMax || aux2 > pesoMax)
                    continue;

                orcamentoIncremental = aux1;
                pesoIncremental =  aux2;
                disponivel.add(productList.get(i));
                disponivel.add(productList.get(j));
            }


        System.out.println("Através do Força Bruta, conseguimos alocar um total de: "+disponivel.size() + " produtos");
        System.out.println("Orçamento total para essa compra: "+ orcamentoIncremental);
        System.out.println("Peso total para essa compra: "+ pesoIncremental);
    }

}
