package algoritmos.mochila;

public class Item{
    private int valor;
    private int peso;


    public Item(int peso, int valor) {
        this.peso=peso;
        this.valor=valor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "valor=" + valor +
                ", peso=" + peso +
                '}';
    }
}
