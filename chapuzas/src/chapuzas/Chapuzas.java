package chapuzas;

public class Chapuzas {

	public static void imprimir_array(int[] array) {
		
		System.out.print("[ ");
		for(int elemento : array ) {
			System.out.print(elemento+" ");
		}
		System.out.println("] ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int tam = 4;
		int permutaciones = (int) Math.pow(2, tam);
		
		for(int i = 0; i<permutaciones; i++) {
			int [] actual = new int[tam];
			int permutacion_aux = i;
			
			for(int j =0; j<tam;j++) {
			
				actual [tam -1 -j] = permutacion_aux%2;
				permutacion_aux = permutacion_aux/2;
			}
			
			imprimir_array(actual);
		}
	}

}
