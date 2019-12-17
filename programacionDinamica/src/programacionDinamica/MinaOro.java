package programacionDinamica;

public class MinaOro {
	//MUY IMPORTANTE: EN ESTE CASO SE INVIERTE EL ORDEN DE LOS BUCLES ANIDADOS: PRIMERO VAMOS FILA POR FILA Y LUEGO CAMBIAMOS A COLUMNAS
	
	public static void imprimir (int[][] array) {
		for(int i = 0; i<array.length;i++) {
			for(int j = 0;j<array[i].length;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static int resolver(int[][] mina) {
		
		int[][] soluciones = new int[mina.length][mina[0].length];
		
		//primera columna de soluciones con los mismos valores que la mina (no tenemos nada acumulado)
		
		for(int i = 0;i<soluciones.length;i++)
		{
			soluciones[i][0] = mina[i][0];
		}
		
		for(int j = 1;j<soluciones[0].length;j++)
		{
			for(int i =0; i<soluciones.length;i++)
			{
				//3 casos
				
				int valor_derecha = soluciones[i][j-1]; //siempre se puede calcular
				int valor_descenso = 0;
				int valor_ascenso = 0;
				
				if(i > 0) {
					
					valor_descenso = soluciones[i-1][j-1];
				}
				
				if(i<soluciones.length-1) {
					
					valor_ascenso = soluciones[i+1][j-1]; 
				}
				
				int escogido = Math.max(valor_derecha, Math.max(valor_ascenso, valor_descenso));
				//System.out.println("para "+i+" y "+j+" hemos escogido el numero "+escogido);
				soluciones[i][j] = mina[i][j] +  escogido;
				
					
			}
		}
		
		imprimir(soluciones);
		
		//devolverá el valor más grande de la ultima columna
		int mayor = soluciones[0][soluciones[0].length-1];
		for(int i = 1; i<soluciones.length;i++)
		{
			mayor = Math.max(mayor, soluciones[i][soluciones[i].length-1]);
		}
		
		return mayor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gold [][] = { {1, 3, 1, 5}, 
                		{2, 2, 4, 1}, 
                		{5, 0, 2, 3}, 
                		{0, 6, 1, 2} }; 
		
		int mat[][] = {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
		

		
		
		System.out.println(resolver(mat));
	}

}
