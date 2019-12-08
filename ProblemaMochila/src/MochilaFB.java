/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaFB extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
        // Completar la implementacion
		
		
		int elementos = pm.size();
		int peso_maxmo = pm.pesoMaximo;
		//array_solicion: ir comprobando soluciones posibles
		//max_solucion: guaramos la que sea mejor
		//max_valor: guardamos el valor de max solución
		
		int max_valor = 0;
		int [] array_solucion = new int [elementos];
		int [] max_solucion = new int [elementos];
		
		for(int elemento : array_solucion) {
			elemento = 0;
		}
		
		for(int elemento :max_solucion) {
			elemento = 0;
		}
		
		//comprobamos todas las posibles opciones
		//en cada caso, comparamos el valor con max_valor. Si es mayor, sustituimos max_solucion;
		//en cualquier caso, el peso no puede pasar de peso_maximo;

		return sm;
	}
	
	
}
