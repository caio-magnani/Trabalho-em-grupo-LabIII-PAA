package algoritmos.mochila;

import java.util.LinkedList;

public class MochilaProgramacaoDinamica extends Mochila{

    /*
    #   y 0 1 2 3
    # x
    # 0   (0,0) (0,1) (0,2)
    # 1   (1,0) (1,1) (1,2)
    # 2   (2,0) (2,1) (2,2)
    *
    # Se getAtualX==2 e getAtualY==2
    #   getAtual==table[2][2]
    #   getAnteriorX==table[1][2]
    #   getAnteriorY==table[2][1]
    */
    private static TabelaItens table;
    private int pesoDaFase=Item.PESOMAX;
    @Override
    public LinkedList<Item> preparationSet(int n) {
        LinkedList<Item> dadosRetorno=super.preparationSet(n);
        table=new TabelaItens(n ,capacidade/pesoDaFase);

        for (int i=1;i<=capacidade/pesoDaFase;i++){
            table.getAnyOne(0,i).add(new Item(pesoDaFase *(i),0));
        }
            table.getAnyOne(0,capacidade/pesoDaFase).set(0,new Item(capacidade,0));
        for (int i=0;i<n+1;i++){
            table.getAnyOne(i,0).add(new Item(0));
        }
        return dadosRetorno;
    }

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        System.out.println("Capacidade da mochila = "+capacidade);
        System.out.println("Com os dados abaixo \n"+dadosCriados.toString());
        dadosCriados.sort(Item::compareTo);
        for (int x=0;x<n;x++){
            for (int y=0;y<capacidade/pesoDaFase;y++) {
                for (int i=0;i<table.getIndiceLinha();i++){
                    table.getAtual().add(dadosCriados.get(i));
                }
                while (table.getAtualPesoMax()< table.getPesoDeAtual()&&table.getAtual().size()!=1) {
                    table.getAtual().removeFirst();
                }
                if (table.getAnteriorValor(false)>table.getValorDeAtual()){
                    table.getAtual().clear();
                    table.getAtual().addAll(table.getAnterior(false));
                }
                if (table.getAnteriorValor(true)>table.getValorDeAtual()){
                    table.getAtual().clear();
                    table.getAtual().addAll(table.getAnterior(true));
                }
                table.next();
            }
        }
        System.out.println("A programacao dinamica\n A melhor combinacao"+table.getUltimo().toString());
        System.out.println("Com valor de = "+table.getUltimoValor());
        System.out.println("E peso de : "+table.getUltimo().stream().mapToInt(Item::getPeso).sum());
    }
}
