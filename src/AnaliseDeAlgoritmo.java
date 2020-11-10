import algoritmos.Algoritmo;

import java.util.LinkedList;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao = 1000;
    public static int n =5;       //tamanho de dado
    public static void main(String[] args) {

    }

    public float AnaliseDeAlgoritmo(Algoritmo algoritmo, int vezesDeRepeticao, int n){
        for (int i=0;i<vezesDeRepeticao;i++){
            //Preparação
            LinkedList dadosAlearórios=algoritmo.preparationSet(n);
            TimerCatcher.setInicioDaOperacao();
            //Algoritmo
            algoritmo.algoritmo(dadosAlearórios,n);
            TimerCatcher.setFimDaOperacao();
            TimerCatcher.tempoDeExecucaoDaOperacao();
        }
        return TimerCatcher.tempoDeExecucaoMedia();
    }
}
