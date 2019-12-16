package programacionDinamica;

public class NumeroSubconjuntosSumaS {


	
	public static int resolver(int[] valores, int suma_max) {
		
		int [][] soluciones = new int [valores.length+1][suma_max+1];
		
		//CASOS BASES
		
		for(int i = 0; i<soluciones.length;i++) {
			
			soluciones[i][0] =1;
		}
		
		for(int i = 1; i<soluciones[0].length;i++) {
			soluciones[0][i] = 0;
		}
		
		
		for(int i = 1; i<soluciones.length;i++) {
			for(int j = 1; j<soluciones[0].length;j++) {
				
				if(valores[i-1]>j) {
					soluciones[i][j] = soluciones[i-1][j];
				}else {
					soluciones[i][j] = soluciones[i-1][j] + soluciones[i-1][j-valores[i-1]];
				}
				
			}
		}
		
		return soluciones[soluciones.length-1][soluciones[0].length-1];
		
	}
	
	public static <NumerosSubconjuntoSumaS> void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] a = {2,3,5,6,8,10};
		 int [] b = {2,4,6,10};
		
		System.out.println( resolver(a,10));
		System.out.println(resolver(b,16));
	}
}
