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
		
	int [] a = new int [4];
	imprimir_array(a);
	//los arrays se inicializan a 0
	
	}

}
