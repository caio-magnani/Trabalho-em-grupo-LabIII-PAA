import java.util.LinkedList;
import java.util.List;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao = 1000;
    public static int n =5;       //tamanho de dado
    public static void main(String[] args) {
        System.out.println(AnaliseDeExemplo(vezesDeRepeticao, n));
    }

    public static float AnaliseDeExemplo(int vezesDeRepeticao,int n){
        for (int i=0;i<vezesDeRepeticao;i++){
            //Preparação
            //List<Integer> dadosCriadosExemplo= Algoritmos.criandoDadosDeExemplo(n);


            TimerCatcher.setInicioDaOperacao();
            //Algoritmo
            //Algoritmos.exemplo(dadosCriadosExemplo , n);


            TimerCatcher.setFimDaOperacao();
            TimerCatcher.tempoDeExecucaoDaOperacao();
        }
        return TimerCatcher.tempoDeExecucaoMedia();
    }
}
