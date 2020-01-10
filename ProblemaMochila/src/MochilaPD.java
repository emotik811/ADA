import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaPD extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {

		
		// i objetos j pesos
		int[][] valores = new int[pm.getPesos().length + 1][pm.getPesoMaximo() + 1]; // +1 para los casos 0

		// CASO BASE 1: PESO_MAXIMO == 0
		for (int i = 0; i < valores.length; i++) {
			valores[i][0] = 0;
		}
		// CASO BASE 2: NO HAY OBJETOS
		for (int i = 1; i < valores[0].length; i++) {
			valores[0][i] = 0;
		}

		// CASO GENERAL

		for (int i = 1; i < valores.length; i++) {
			for (int j = 1; j < valores[i].length; j++) {
				// si cabe el objeto
				if (j >= pm.getPeso(i - 1)) {

					valores[i][j] = Math.max(valores[i - 1][j],
							pm.getValor(i - 1) + valores[i - 1][j - pm.getPeso(i - 1)]);
				} else {
					// si no cabe el objeto
					valores[i][j] = valores[i - 1][j];
				}

			}
		}

		// en este punto tenemos el valor máximo:
		int j = valores[0].length - 1;
		int valor = valores[valores.length - 1][j];
		int[] items = new int[pm.getPesos().length];

		for (int i = valores.length - 1; i > 0; i--) {

			// si valores[i-1,j]<valores[i,j] --> i está
			if (valores[i - 1][j] < valores[i][j]) {
				items[i - 1] = 1;
				j = j - pm.getPeso(i - 1);
			}
		}

		// llegado a este punto se tiene que tener el array de items
		int peso = 0;
		for (int i = 0; i < items.length; i++) {
			peso += items[i] * pm.getPeso(i);
		}

		SolucionMochila sol = new SolucionMochila(items, peso, valor);
		return sol;

	}
}
