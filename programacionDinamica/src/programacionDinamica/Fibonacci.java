package programacionDinamica;

//Sucesi�n de Fibonacci por progrmaaic�n din�mica
//Para calcular un n�mero usamos los dos anteriores
//Casos base, los dos primeros elementos
public class Fibonacci {

	public static int fibonacci(int a) {

		if (a == 0) {
			return 0;
		} else if (a == 1) {
			return 1;
		} else {
			int[] fib = new int[a+1];
			fib[0] = 0;
			fib[1] = 1;

			for (int i = 2; i <=a; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}
			imprimirArray(fib);
			return fib[a];
		}

	}

	public static void imprimirArray(int[] array) {
		for (int i : array) {
			System.out.print(" " + i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero = 9;
		System.out.println("Fib = "+fibonacci(numero));
		
	}

}
