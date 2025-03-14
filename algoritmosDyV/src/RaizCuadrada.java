

public class RaizCuadrada {

	public static int obtenerRaizCuadrada(int N, int inf, int sup)
	{
		
		if(inf==sup) {
			return inf;
		}else {
			
			int elemento_medio= (sup+inf)/2;
			
			int posible = elemento_medio*elemento_medio;
			if(posible==N) {
				return elemento_medio;
			}else if(posible>N) {
				return obtenerRaizCuadrada(N,inf, elemento_medio-1);
			}else {
				return obtenerRaizCuadrada(N,elemento_medio+1, sup);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,4,9,16,25,36,49,100,121};
		
		for(int N : array)
			System.out.println(obtenerRaizCuadrada(N,1,N));
	}

}
