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
    private int pesoDaFase;
    @Override
    public LinkedList<Item> preparationSet(int n) {
        LinkedList<Item> dadosRetorno=super.preparationSet(n);
        pesoDaFase =capacidade/n;
        table=new TabelaItens(n,n);
        for (int i=1;i<n+1;i++){
            table.getAnyOne(0,i).add(new Item(pesoDaFase *(i+1),0));
        }
            table.getAnyOne(0,n).set(0,new Item(capacidade,0));
        for (int i=0;i<n+1;i++){
            table.getAnyOne(i,0).add(new Item(0,0));
        }
        return dadosRetorno;
    }

    @Override
    public void resolver(LinkedList<Item> dadosCriados, int n) {
        for (int x=0;x<n;x++){
            for (int i=0;i<table.getIndiceLinha();i++){
                table.getAtual().add(dadosCriados.get(i));
            }
            for (int y=0;y<n;y++) {
                if (table.getAtualPesoMax()< table.getPesoDeAtual()) {
                    table.getAtual().remove(0);
                }
                if (table.getAnteriorValor(true)>table.getValorDeAtual()){
                    table.getAtual().clear();
                    table.getAtual().addAll(table.getAnterior(true));
                }
                if (table.getAnteriorValor(false)>table.getValorDeAtual()){
                    table.getAtual().clear();
                    table.getAtual().addAll(table.getAnterior(false));
                }

                table.next();
            }
        }
    }
}
