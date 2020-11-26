import algoritmos.Algoritmo;
import algoritmos.mochila.Mochila;
import algoritmos.mochila.MochilaBackTracking;
import algoritmos.mochila.MochilaForcaBruta;
import algoritmos.mochila.MochilaProgramacaoDinamica;

import java.util.LinkedList;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao = 1;
    public static int n=700;       //tamanho de dado

    public static void main(String[] args) {
        MochilaForcaBruta mFB=new MochilaForcaBruta();
        MochilaBackTracking mBT=new MochilaBackTracking();
        MochilaProgramacaoDinamica mPD=new MochilaProgramacaoDinamica();
        System.out.println(AnaliseDeAlgoritmo(mPD));
    }

    public static float AnaliseDeAlgoritmo(Algoritmo algoritmo){
        for (int i=0;i<vezesDeRepeticao;i++){
            //Preparação
            LinkedList dadosAlearórios=algoritmo.preparationSet(n);
            TimerCatcher.setInicioDaOperacao();
            //Algoritmo
            algoritmo.resolver(dadosAlearórios,n);
            TimerCatcher.setFimDaOperacao();
            TimerCatcher.tempoDeExecucaoDaOperacao();
        }
        return TimerCatcher.tempoDeExecucaoMedia();
    }
}
