import algoritmos.Algoritmo;
import algoritmos.mochila.*;
import timer_catcher.TimerCatcher;
import java.util.LinkedList;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao =1;
    public static int n=100;       //tamanho de dado

    public static void main(String[] args) {

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
    public static void test(Algoritmo algoritmo){
        MochilaForcaBruta mFB=new MochilaForcaBruta();
        MochilaProgramacaoDinamica mPD=new MochilaProgramacaoDinamica();
        LinkedList dadosAlearórios=mPD.preparationSet(n);
        System.out.println();
        System.out.println();
        mPD.resolver(dadosAlearórios,n);
        System.out.println();
        System.out.println();
        mFB.resolver(dadosAlearórios,n);
        System.out.println();
        System.out.println();
        algoritmo.resolver(dadosAlearórios,n);
    }
    public static LinkedList<Item> casosDeTesteMochila(int i,Mochila algoritmo,int n){
        LinkedList<Item> teste=new LinkedList<>();
        teste=algoritmo.preparationSet(n);
        int pesoTotal = teste.stream().mapToInt(p -> p.getPeso()).sum();
        int quantTotal = teste.size();
        float media = (float)pesoTotal/quantTotal;
        int capacidade =(int)Math.ceil(media * 6.5F);
        if(i==0){
            System.out.println("T - no meio");
            teste.set(n/2,new Item(capacidade,9999999999F));
        }
        else
        if (i==1){
            System.out.println("T - no inicio");
            teste.set(0,new Item(capacidade,9999999999F));
        }
        else
        if (i==2){
            System.out.println("T - no fim");
            teste.set(teste.size()-1,new Item(capacidade,9999999999F));
        }
        else
        if (i==3){
            System.out.println("T - é todos");
            for (int j=0;j<teste.size();j++){
                teste.set(j,new Item(0,1000F));
            }
        }
        else
        if (i==4){
            AnaliseDeAlgoritmo(algoritmo);
        }
        return teste;
    }

}
