package algoritmos.supermercado;

import algoritmos.Algoritmo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class SupermercadoForcaBruta implements Algoritmo<Produto>
{
    public LinkedList<Produto> preparationSet(int n) {
        LinkedList<Produto> productList = new LinkedList<Produto>();
        String[] products = new String[n];
        double[] preco = new double[n];
        int[] peso = new int[n];
        Random random = new Random();

        for(int i = 0; i < products.length ; i++)
        {
            int numero = random.nextInt(50);
            double numeroDouble = random.nextDouble() * 50;
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
        boolean repeat = false;

        // FORÇA BRUTA
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
                int index = disponivel.indexOf(productList.get(i));
                if(repeat || index == -1)
                    disponivel.add(productList.get(i));
                index = disponivel.indexOf(productList.get(j));
                if(repeat || index == -1)
                    disponivel.add(productList.get(j));
            }

        System.out.println("Temos um total de " + disponivel.size() + " itens na lista");
    }

}
