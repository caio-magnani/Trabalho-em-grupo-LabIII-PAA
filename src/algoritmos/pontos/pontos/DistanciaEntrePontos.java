package algoritmos.pontos;

import algoritmos.Algoritmo;

import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public abstract class DistanciaEntrePontos implements Algoritmo<Point>{
    static final int TOTALPONTOS = 50000;
    static final int MINPONTOS = 2;

    static Random sorteio = new Random(42);

    static LinkedList<Point> geraPontos(int quantPontos) {
        LinkedList<Point> pontos = new LinkedList<Point>();
        for (int i = 0; i < quantPontos; i++) {
            pontos.add(new Point(sorteio.nextInt(TOTALPONTOS), sorteio.nextInt(TOTALPONTOS)));
        }
        return pontos;
    }

    @Override
    public LinkedList<Point> preparationSet(int n) {
        return geraPontos(n);
    }
}
