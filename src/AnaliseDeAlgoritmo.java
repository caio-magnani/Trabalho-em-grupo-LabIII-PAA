import algoritmos.Algoritmo;
import algoritmos.mochila.*;
import algoritmos.pontos.DEPDivisaoEConquista;
import algoritmos.pontos.DEPForcaBruta;
import algoritmos.supermercado.SupermercadoBackTracking;
import algoritmos.supermercado.SupermercadoForcaBruta;
import timer_catcher.TimerCatcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class AnaliseDeAlgoritmo {
    public static int vezesDeRepeticao =1;
    public static int n=100;       //tamanho de dado

    public static void main(String[] args) {
        int opcaoProblema=0;
        int opcaoSolucao=0;
        Scanner leitor =new Scanner(System.in);
        System.out.println("Escreva a quantidade de: n = tamanho do seu problema:");
        n=Integer.parseInt(leitor.nextLine());
        System.out.println("Escreva a quantidade de: veses de repetção - quantidade de testes com mesmo n");
        vezesDeRepeticao=Integer.parseInt(leitor.nextLine());
        System.out.println("Escolha um problema");
        System.out.println("0-Mochila");
        System.out.println("1-Par de Pontos");
        System.out.println("2-Supermercado");
        System.out.println("3-Robo");
        opcaoProblema=Integer.parseInt(leitor.nextLine());
        if(opcaoProblema==0){
            System.out.println("Mochila Escolhida");
            System.out.println("0-Deseja resolver a Mochila com a solução: força bruta BRUTAL");
            System.out.println("1-Deseja resolver a Mochila com a solução: programação dinamica");
            System.out.println("2-Deseja resolver a Mochila com a solução: algoritmo guloso");
            opcaoSolucao=Integer.parseInt(leitor.nextLine());
            if(opcaoSolucao==0){
                AnaliseDeAlgoritmo(new MochilaForcaBruta());
            }
            if(opcaoSolucao==1){
                AnaliseDeAlgoritmo(new MochilaProgramacaoDinamica());
            }
            if(opcaoSolucao==2){
                AnaliseDeAlgoritmo(new MochilaAlgoritmoGuloso());
            }
        }
        if(opcaoProblema==1){
            System.out.println("Par de Pontos Escolhido");
            System.out.println("0-Deseja resolver a Par de Pontos com a solução: força bruta");
            System.out.println("1-Deseja resolver a Par de Pontos com a solução: divisão e conquista");
            opcaoSolucao=Integer.parseInt(leitor.nextLine());
            if(opcaoSolucao==0){
                AnaliseDeAlgoritmo(new DEPForcaBruta());
            }
            if(opcaoSolucao==1){
                AnaliseDeAlgoritmo(new DEPDivisaoEConquista());
            }
        }
        if(opcaoProblema==2)
        {
            System.out.println("Supermercado Escolhido");
            System.out.println("0-Deseja resolver a Supermercado com a solução: força bruta");
            System.out.println("1-Deseja resolver a Supermercado com a solução: divisão e conquista");
            opcaoSolucao=Integer.parseInt(leitor.nextLine());
            if(opcaoSolucao==0){
                AnaliseDeAlgoritmo(new SupermercadoForcaBruta());
            }
            if(opcaoSolucao==1){
                AnaliseDeAlgoritmo(new SupermercadoBackTracking());
            }
        }
        if(opcaoProblema==3)
        {
            System.out.println("Execute Main.java do diretorio src/algoritmos/robo");
        }
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
