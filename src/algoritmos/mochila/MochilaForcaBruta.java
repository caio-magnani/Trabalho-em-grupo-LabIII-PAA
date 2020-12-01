package algoritmos.mochila;

import java.util.LinkedList;

public class MochilaForcaBruta extends Mochila{
    LinkedList<Item> combinacaoAtual = new  LinkedList<>();
    LinkedList<Item> melhorCombinacao = new  LinkedList<>();
    Double melhorSoma=0D;

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        System.out.println("Capacidade da mochila = "+capacidade);
        System.out.println("Com os dados abaixo \n"+dadosCriados.toString());
        LinkedList<LinkedList<Item>>possiveis=new LinkedList<LinkedList<Item>>();//Gera as possibilidades
        LinkedList<LinkedList<Item>> dones=new LinkedList<>();//Quarda as possibilidades prontas
        for (int i=0;i<n;i++){//inicia
            possiveis.add(new LinkedList<Item>());
            dones.add(new LinkedList<Item>());
        }
        for (int i=0;i<n;i++) {//adiciona os primeiros
            possiveis.get(i).add(dadosCriados.get(i));
            dones.get(i).add(dadosCriados.get(i));
        }
        while (possiveis.size()!=0){//adiciona ate acabar todos
            for (int i=0;i<possiveis.size();i++){//for pra adicionar um a um os valores
                                                 // (se n adiciona os ponteiros só ;-;)
                LinkedList<Item> novo=new LinkedList<Item>();
                possiveis.get(i).forEach(item -> novo.add(item.getItem()));
                dones.add(novo);
            }
        possiveis.forEach(items -> {
                if (items.contains(dadosCriados.getLast())){

                    possiveis.remove(items);
                }
                else
                items.add(dadosCriados.get(dadosCriados.indexOf(items.getLast())+1));
        }
        );
        }
        for (int i=0;i<dones.size();i++){
            combinacaoAtual=dones.get(i);
            verificar();
        }
        System.out.println(dones.toString());
        System.out.println("O Forca Bruta \nAchou o valor de ="+
                melhorCombinacao.stream().mapToDouble(Item::getValor).sum());
        System.out.println("Peso da solução ="+melhorCombinacao.stream().mapToInt(Item::getPeso).sum());
        System.out.println("Melhor seguencia abaixo \n"+melhorCombinacao.toString());
    }

    private void verificar() {
        Double atualSoma=combinacaoAtual.stream().mapToDouble(Item::getValor).sum();
        int atualPeso=combinacaoAtual.stream().mapToInt(Item::getPeso).sum();
        if (capacidade>=atualPeso) {
            if (melhorSoma < atualSoma) {
                melhorCombinacao.clear();
                melhorCombinacao.addAll(combinacaoAtual);
                melhorSoma = atualSoma;
            }
        }
    }
}
