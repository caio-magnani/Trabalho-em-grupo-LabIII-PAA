package algoritmos.pontos;

import java.awt.*;
import java.util.LinkedList;

public class DEPForcaBruta extends DistanciaEntrePontos{

    @Override
    public void resolver(LinkedList<Point> dadosCriados, int n) {

        int [] vetor_x = new int[n/2];
        int [] vetor_x1 = new int[n/2];
        int [] vetor_y = new int[n/2];
        int [] vetor_y1 = new int[n/2];
        int i;
        for (i = 0; i < n/2; i++) {
            Point p = dadosCriados.get(i);

            vetor_x[i] = p.x;
            vetor_y[i] = p.y;
        }

        for (i = n/2; i < n; i++) {
            Point p = dadosCriados.get(i);

            vetor_x1[i-n/2] = p.x;
            vetor_y1[i-n/2] = p.y;
        }
       App.bruteForce(i, n, vetor_x, vetor_y, vetor_x1, vetor_y1);
    }
}
