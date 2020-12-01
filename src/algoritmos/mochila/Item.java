package algoritmos.mochila;

import java.util.Comparator;
import java.util.Random;
/** 
 * MIT License
 *
 * Copyright(c) 2020 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class Item implements Comparable {
    static Random sorteio = new Random(42);                  //--> fixo
    //static Random sorteio = new Random(System.nanoTime());   --> aleatório 
    static final int PESOMAX = 50;
    static final float VALMAX = 40f;

    int peso;
    float valor;
    private Item o;

    public Item getItem() {
        return this;
    }

    public Item(int i) {
        this.peso = i;
        this.valor = i;
    }

    public int getPeso() {
        return peso;
    }

    public float getValor() {
        return valor;
    }

    public Item(){
        this.peso = 1+sorteio.nextInt(PESOMAX);
        this.valor = (float)(peso*2+sorteio.nextDouble()*VALMAX) ;
    }

    public Item(int peso, float valor) {
        this.peso = peso;
        this.valor = valor;
    }
    public Item(Item item){
        this.peso=item.peso;
        this.valor=item.valor;
    }

    @Override
    public String toString(){
        return "P: "+this.peso+" | V: "+this.valor;
    }

    @Override
    public int compareTo(Object o) {
        return compareToItem((Item) o);
    }

    private int compareToItem(Item o) {
        if (this.peso==o.peso&&this.valor==o.valor){
            return 0;
        }
        else if (this.peso<=o.peso&&this.valor>= o.valor){
            return 1;
        }
        else if (this.peso>=o.peso&&this.valor<=o.valor){
            return -1;
        }
        else if(this.valor/this.peso>o.valor/o.peso)
        return 1;
        return -1;
    }
}
