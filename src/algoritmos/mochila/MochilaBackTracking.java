package algoritmos.mochila;

import java.util.LinkedList;

public class MochilaBackTracking extends Mochila{
    private static LinkedList<Item> melhorCombinacao=new LinkedList<>();
    private static LinkedList<Item> combinacaoAtual=new LinkedList<>();
    private static LinkedList<Item> dadosCriados;

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        combinacaoAtual.clear();
        melhorCombinacao.clear();
//        System.out.println("Capacidade da mochila = "+capacidade);
//        System.out.println("Com os dados abaixo \n"+dadosCriados.toString());
        this.dadosCriados=dadosCriados;
        backTracking();
//        System.out.println("O BackTrack \nAchou o valor de ="+melhorCombinacao.stream().mapToDouble(Item::getValor).sum());
//        System.out.println("Peso da solução ="+melhorCombinacao.stream().mapToInt(i->i.peso).sum());
//        System.out.println("Melhor seguencia abaixo \n"+melhorCombinacao.toString());
    }
    //j = indece da combinacaoAtual i= indice de dados criados
    private int back(int i){
        combinacaoAtual.removeLast();
        return ++i;
    }
    private int ehFim(int i){
        if (combinacaoAtual.get(0).compareTo(dadosCriados.get(dadosCriados.size()-1))==0)
            return dadosCriados.size();
        else
            return verificar(i);
    }
    private int verificar(int i){
        if (combinacaoAtual.stream().mapToInt(Item::getPeso).sum()>capacidade){
            return back(i);
        }
        else if(combinacaoAtual.stream().mapToDouble(Item::getValor).sum()>melhorCombinacao.stream().mapToDouble(Item::getValor).sum()){
            for (int j=0;j<combinacaoAtual.size();j++){
                melhorCombinacao.add(combinacaoAtual.get(i).getItem());
            }
        }
        return i;
    }
    private void backTracking(){
        for (int i=0;i<dadosCriados.size();i++){
            combinacaoAtual.add(dadosCriados.get(i));
            i=ehFim(i);
        }
    }
}
