package algoritmos.pontos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class App {

	public static double FLT_MAX = 1000000000;

	static public Point[] p(int n, int maxX, int maxY) {

		ArrayList<Point> nova = new ArrayList<Point>(n);
		Random aleat = new Random(42);

		int[] vetor_x = new int[n];
		int[] vetor_x1 = new int[n];
		int[] vetor_y = new int[n];
		int[] vetor_y1 = new int[n];
		int i;
		int[] vetorX = new int[2 * n];
		int[] vetorY = new int[2 * n];

		int[] meioX = new int[n];
		int[] meioX1 = new int[n];
		int[] meioY = new int[n];
		int[] meioY1 = new int[n];
		int tamanhoX = vetorX.length / 2;
		double distanciaDC=0;
		double distanciaDC1=0;
		double distanciaMeio=0;
		double menorDistancia =0;
		double distancia = 0;


		for (i = 0; i < n; i++) {
			int x = aleat.nextInt(maxX);
			int y = aleat.nextInt(maxY);
			Point p = new Point(x, y);

			vetor_x[i] = p.x;
			vetor_y[i] = p.y;
			nova.add(p);
			System.out.println(vetor_x[i]+" ,"+vetor_y[i]);
		}
		for (i = 0; i < n; i++) {

			int x = aleat.nextInt(maxX);
			int y = aleat.nextInt(maxY);
			Point p = new Point(x, y);

			vetor_x1[i] = p.x;
			vetor_y1[i] = p.y;

			nova.add(p);

		}
		System.out.println(nova);
		for (i = 0; i < n; i++) {
			System.out.print("x1: " + vetor_x[i] + ", ");
			System.out.print("y1: " + vetor_y[i] + ", ");
			System.out.print("x2: " + vetor_x1[i] + ", ");
			System.out.print("y2: " + vetor_y1[i] + ", ");
			System.out.println();

			distancia = distancia(i, vetor_x, vetor_y, vetor_x1, vetor_y1);
			System.out.println("Distancia Euclidiana: " + distancia);
			System.out.println();

		}

		//Funcao algortimo de For�a Bruta
		long startTime1 = System.nanoTime();
		bruteForce(i, n, vetor_x, vetor_y, vetor_x1, vetor_y1);
		long endTime1 = System.nanoTime();
		double tempot1 = endTime1 - startTime1;
		System.out.println("Tempo gasto Funcao Forca Bruta: " + tempot1);


		long startTime = System.nanoTime();
		//concatena vetor de X e de Y
		vetorX = concatenarVetorX(vetor_x, vetor_x1);
		vetorY = concatenarVetorY(vetor_y, vetor_y1);


		bubbleSort(n,vetorX,vetorY); //ordena coordenada de x

		divideVetor(n, vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Divide a quantidade de coordenadas pela metade

		distanciaDC =  divisaoC(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Menor Distancia da primeira metade
		distanciaDC1 =  divisaoC1(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1); // Menor Distancia da segunda metade
		//compara a distancia das duas metades e encontra a menor
		if(distanciaDC< distanciaDC1 && distanciaDC != 0)
			menorDistancia = distanciaDC;
		else menorDistancia =  distanciaDC1;

		//Menor distancia entre as coordenas do meio
		distanciaMeio =  divisaoMeio(vetorX,vetorY,tamanhoX, meioX, meioX1, meioY, meioY1);

		//compara a distancia entre as coordenadas do meio e as duas metades
		if(distanciaMeio< menorDistancia&& distanciaMeio != 0)
			menorDistancia = distanciaMeio;
		System.out.println();
		System.out.println("Menor Distancia Divisao e Conquista: "+menorDistancia);

		long endTime = System.nanoTime();
		double tempot = endTime - startTime;
		System.out.println("Tempo gasto Funcao Divisao e Conquista: " + tempot);

		Point[] aux = new Point[nova.size()];
		aux = nova.toArray(aux);
		return aux;
	}

	// Distancia Euclidiana
	// Funcao que retorna Distancia euclidiana entre os pontos iniciais de X e Y
	public static double distancia(int i, int[] vetor_x, int[] vetor_y, int[] vetor_x1, int[] vetor_y1) {

		return Math.sqrt(Math.pow((vetor_x[i] - vetor_x1[i]), 2) + Math.pow((vetor_y[i] - vetor_y1[i]), 2));

	}
	
	//Determina a menor distancia de meio x e x1, y e y1
	public static double divisaoC(int[] vetorX, int[] vetorY, int tamanhoX, int[] meioX, int[] meioX1, int[] meioY, int[] meioY1){
		double distanciaDC = 0 ;
		double min = 10000;
		
		for(int i =0; i < tamanhoX; i++) {
			for(int j=1; j < tamanhoX; j++) {
				
				if (i != j)
				distanciaDC = Math.sqrt(Math.pow((meioX[i] - meioX[j]), 2) + Math.pow((meioY[i] - meioY1[j]), 2));

				
				if (distanciaDC < FLT_MAX) {
					min = distanciaDC;					

				}	
			}	
		}
		return	 min;
	}
	
	//Determina a menor distancia de meio x e x1, y e y1
	public static double divisaoC1(int[] vetorX, int[] vetorY, int tamanhoX, int[] meioX, int[] meioX1, int[] meioY, int[] meioY1){
		double distanciaDC = 0 ;
		double min = 1000000000;
		
		for(int i = 0; i < tamanhoX; i++) {
			for(int j=1; j < tamanhoX; j++) {
				
				if (i != j)
				distanciaDC = Math.sqrt(Math.pow((meioX1[i] - meioX1[j]), 2) + Math.pow((meioY1[i] - meioY1[j]), 2));
				if (distanciaDC < FLT_MAX) 
					min = distanciaDC;
				}
		}
		return	 min;
	}
	//Funcao para dividir valores ao meio 
	
	public static double divisaoMeio(int[] vetorX, int[] vetorY, int tamanhoX, int[] meioX, int[] meioX1, int[] meioY, int[] meioY1){
		double distanciaDC = 0 ;
		
		distanciaDC = Math.sqrt(Math.pow((meioX[tamanhoX-1 ] - meioX1[1]), 2) + Math.pow((meioY[tamanhoX -1] - meioY1[1]), 2));
			
		return	 distanciaDC;
	}
	
	//concatena ponto X com ponto X1
	static public int[] concatenarVetorX(int[] vetor_x, int[] vetor_x1) {
		int[] concatenarX = new int[vetor_x.length + vetor_x1.length];
		int cont = 0;
		for (int i = 0; i < vetor_x.length; i++)
			concatenarX[cont++] = vetor_x[i];
		for (int i = 0; i < vetor_x1.length; i++)
			concatenarX[cont++] = vetor_x1[i];
		return concatenarX;
	}
	//Concatena Ponto Y com Y1
	static public int[] concatenarVetorY(int[] vetor_y, int[] vetor_y1) {
		int[] concatenarY = new int[vetor_y.length + vetor_y1.length];
		int cont = 0;
		for (int i = 0; i < vetor_y.length; i++)
			concatenarY[cont++] = vetor_y[i];

		for (int i = 0; i < vetor_y1.length; i++)
			concatenarY[cont++] = vetor_y1[i];
		return concatenarY;
	}
	
	//Funcao para realizar bubbleSort no vetor de X e Y
	
	static public void bubbleSort(int n, int[] vetorX, int[] vetorY){
        boolean troca = true;
        int aux;  
        int aux1;
        
        while (troca) {
            troca = false;
            for (int i = 0; i < vetorX.length - 1; i++) {
                if (vetorX[i] > vetorX[i + 1]) {
                    aux = vetorX[i];
                    vetorX[i] = vetorX[i + 1];
                    vetorX[i + 1] = aux;
                    aux1 = vetorY[i];
                    vetorY[i] = vetorY[i + 1];
                    vetorY[i + 1] = aux1;
                    troca = true;
                }
            }
        }
//        for (int i = 0; i < 2*n; i++) {      //teste para ver impress�o
//        	System.out.println(vetorX[i]);
//        }
//       System.out.println(" ****************************** ");
//        for (int i = 0; i < 2*n; i++) {		 
//			 System.out.println(vetorY[i]);
//		 }
	}
	
	//funcao para dividir o vetor X e Y dentro de outros vetores, tendo assim seus valores pela metade
	static public void divideVetor(int n, int[] vetorX, int[] vetorY, int tamanhoX, int[] meioX, int[] meioX1, int[] meioY, int[] meioY1) {
		
		
		for (int i = 0; i < tamanhoX; i++) {
			meioX[i] = vetorX[i];
		}
		for (int i = n; i < vetorX.length ; i++) {
			meioX1[i-n] = vetorX[i];
		}
		for (int i = 0; i < tamanhoX; i++) {
			meioY[i] = vetorY[i];
		}
		for (int i = n; i < vetorX.length ; i++) {
			meioY1[i-n] = vetorY[i];
		}
		
//		System.out.println("--------------------------------------------");
//		System.out.println("Meio X: ");
//		for (int i = 0; i < tamanhoX ; i++) {
//			System.out.println(meioX[i]);
//		}
//		System.out.println("Meio X1: ");
//		for (int i = n; i < vetorX.length ; i++) {
//			System.out.println(meioX1[i-n]);
//		}
//		System.out.println("Meio Y: ");
//		for (int i = 0; i < tamanhoX; i++) {
//			System.out.println(meioY[i]);
//		}
//		System.out.println("Meio Y1: ");
//		for (int i = n; i < vetorX.length ; i++) {
//			System.out.println(meioY1[i-n]);
//		}
	}
	
	//Funcao de forca bruta para determinar Menor valor e Qual suas posicoes 
	
	static public double bruteForce(int i, int n, int[] vetor_x, int[] vetor_y, int[] vetor_x1, int[] vetor_y1) {
		double min = FLT_MAX;

		int xFinal=0;
		int x1Final=0;
		int yFinal=0;
		int y1Final=0;

		for (i = 0; i < n/2; ++i) {
			if (distancia(i, vetor_x, vetor_y, vetor_x1, vetor_y1) < min) {
				min = distancia(i, vetor_x, vetor_y, vetor_x1, vetor_y1);
				xFinal = vetor_x[i];
				x1Final = vetor_x1[i];
				yFinal = vetor_y[i];
				y1Final = vetor_y1[i];

			}
		}
		System.out.println("Menor Distancia Forca Bruta:" + min);
		System.out.print("x1: " + xFinal + ", ");
		System.out.print("y1: " + yFinal + ", ");
		System.out.print("x2: " + x1Final + ", ");
		System.out.print("y2: " + y1Final + ", ");
		System.out.println();

		return min;
		
	}
}