import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaPD extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
	
		// Completar la implementacion
		//Array_soluciones[HASTA ITEM N][PARA PESO M] (+1 para los casos donde no hay item y el peso máximo de la mochila es 0)
		SolucionMochila [][] array_soluciones = new SolucionMochila[pm.getPesos().length+1][pm.getPesoMaximo()+1];

		for(int i = 0; i<array_soluciones.length;i++){

			array_soluciones[i][0] = new SolucionMochila(new int[pm.getPesos().length],0,0);

		}

		for(int i = 1;i<array_soluciones[0].length;i++) {

			array_soluciones[0][i] = new SolucionMochila(new int[pm.getPesos().length],0,0);
		}
		
		
		
		

		for (int i = 1; i < array_soluciones.length; i++) { //objetos

			for(int j = 1; j<array_soluciones[i].length;j++) { //pesos
				
				
				//si el objeto cabe
				if(j>=pm.getPeso(i-1)) {


					int valor_caso1 = array_soluciones[i-1][j].getSumaValores();
					int valor_caso2 =  pm.getValor(i-1)+array_soluciones[i-1][j-pm.getPeso(i-1)].getSumaValores();

					if(valor_caso1>=valor_caso2) {
						//caso1 (no se coge el objeto i)
						
						/*
						SolucionMochila actual = new SolucionMochila( array_soluciones[i-1][j].getSolucion(),array_soluciones[i-1][j].getSumaPesos() ,valor_caso1);
						array_soluciones[i][j] = actual;
						*/
						array_soluciones[i][j]=array_soluciones[i-1][j];
					}else {

						//caso2 (se coge objeto i)

						ArrayList<Integer> objetos = new ArrayList<Integer>();
						objetos.addAll(array_soluciones[i-1][j-pm.getPeso(i-1)].getSolucion());
						objetos.set(i-1,1);
						int suma_actual = array_soluciones[i-1][j-pm.getPeso(i-1)].getSumaPesos() + pm.getPeso(i-1);
						SolucionMochila actual = new SolucionMochila(objetos, suma_actual,valor_caso2);
						array_soluciones[i][j] = actual;

					}

				//si no cabe
				}else {
					
					/*
					SolucionMochila actual = new SolucionMochila( array_soluciones[i-1][j].getSolucion(),array_soluciones[i-1][j].getSumaPesos(),array_soluciones[i-1][j].getSumaValores());
					array_soluciones[i][j] = actual;
					*/
					array_soluciones[i][j] = array_soluciones[i-1][j];
				}
				
			}
		}
		return array_soluciones[array_soluciones.length-1][array_soluciones[0].length-1];
	}


}
