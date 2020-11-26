package algoritmos.pontos;

import java.awt.*;
import java.util.LinkedList;

public class DEPDivisaoEConquista extends DistanciaEntrePontos{

    @Override
    public void resolver(LinkedList<Point> dadosCriados, int n) {
        divisaoEConquista(n,dadosCriados);
    }
    private static void divisaoEConquista(int n,LinkedList<Point>dadosCriados){
        int vetor_x[] = new int[n];
        int vetor_x1[] = new int[n];
        int vetor_y[] = new int[n];
        int vetor_y1[] = new int[n];
        int i = 0;
        int vetorX[] = new int[2 * n];
        int vetorY[] = new int[2 * n];

        int meioX[] = new int[n];
        int meioX1[] = new int[n];
        int meioY[] = new int[n];
        int meioY1[] = new int[n];
        int tamanhoX = vetorX.length / 2;
        double distanciaDC=0;
        double distanciaDC1=0;
        double distanciaMeio=0;
        double menorDistancia =0;
        double distancia = 0;

        for (i = 0; i < n/2; i++) {
            Point p = dadosCriados.get(i);

            vetor_x[i] = p.x;
            vetor_y[i] = p.y;
        }

        for (i = n/2; i < n; i++) {
            Point p = dadosCriados.get(i);

            vetor_x1[i] = p.x;
            vetor_y1[i] = p.y;
        }
        //concatena vetor de X e de Y
        vetorX = App.concatenarVetorX(vetor_x, vetor_x1);
        vetorY = App.concatenarVetorY(vetor_y, vetor_y1);


        App.bubbleSort(n,vetorX,vetorY); //ordena coordenada de x

        App.divideVetor(n, vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Divide a quantidade de coordenadas pela metade

        distanciaDC = App.divisaoC(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Menor Distancia da primeira metade
        distanciaDC1 = App.divisaoC1(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Menor Distancia da segunda metade
        //compara a distancia das duas metades e encontra a menor
        if(distanciaDC< distanciaDC1 && distanciaDC != 0)
            menorDistancia = distanciaDC;
        else menorDistancia =  distanciaDC1;

        //Menor distancia entre as coordenas do meio
        distanciaMeio = App.divisaoMeio(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1);

        //compara a distancia entre as coordenadas do meio e as duas metades
        if(distanciaMeio< menorDistancia&& distanciaMeio != 0)
            menorDistancia = distanciaMeio;
        System.out.println();
        System.out.println("Menor Distancia Divisao e Conquista: "+menorDistancia);
    }
}
