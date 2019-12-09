/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaFB extends Mochila {

	 
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
        // Completar la implementacion
		
		//obtener numero de permutaciones (al ser mochila 0-1, serán potencias de base 2)
		int permutaciones = (int) Math.pow(2, pm.getPesos().length);
		int tam = pm.getPesos().length;
		
		int peso_maximo = pm.getPesoMaximo();
		

		
		for(int i = 0; i<permutaciones; i++) {
			
			int [] actual = new int [tam];
			int permutacion_aux = i;
			int peso_actual = 0;
			int valor_actual = 0;
			for(int j = 0; j<tam;j++)
			{
				actual [tam-1-j] = permutacion_aux%2;
				permutacion_aux = permutacion_aux/2;
				peso_actual = peso_actual + actual[tam-1-j] * pm.getPeso(tam-1-j);
				valor_actual = valor_actual + actual[tam-1-j] * pm.getValor(tam-1-j);		
			}
			if(peso_actual<= peso_maximo ) {
				if(sm==null || sm.getSumaValores()<valor_actual) {
					sm = new SolucionMochila(actual, peso_actual,valor_actual);
				}
			}
		}
		
		//comprobamos todas las posibles opciones
		//en cada caso, comparamos el valor con max_valor. Si es mayor, sustituimos max_solucion;
		//en cualquier caso, el peso no puede pasar de peso_maximo;

		return sm;
	}
	
	
}
