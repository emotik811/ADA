import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author ***** Juan Rosa González*******
 *
 */

public class MochilaAV extends Mochila {

	//CUIDADO
	class ObjetosSort implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			double ratio_1 = (double)o1.valor/(double)o1.peso;
			double ratio_2 = (double)o2.valor/(double)o2.peso;
			
			
			if(ratio_1<ratio_2) {
				return -1;
			}else if(ratio_1 == ratio_2 && o1.valor==o2.valor) {
				return 0;
			}else if(ratio_1==ratio_2 && o1.valor<o2.valor) {
				return -1;
			}else if(ratio_1==ratio_2 && o1.valor>o2.valor) {
				return 1;
			}else {
				return 1;
			}
			

			
		}
		
	}
	
	public SolucionMochila resolver(ProblemaMochila pm) {
		
  
		
		ArrayList<Item> objetos = pm.getItems();
		Collections.sort(objetos, new ObjetosSort());
		//IMPORTANTE: EL ORDEN DE ORCENACIÓN ES ASCENDENTE
		
		
		
		
		//Para este punto el array debería de estar ordenado correctamente
		//OJO: LA ORDENACION ES ASCENDENTE
		
		int valorAcumulado = 0;
		int pesoAcumulado = 0;
		int [] objetosEscogidos = new int [objetos.size()]; 
		
		
		int i =objetos.size()-1;
		
		while(pesoAcumulado<pm.getPesoMaximo() && i >= 0 ) {
			//obejo i<peso
			if(objetos.get(i).peso<= (pm.getPesoMaximo()-pesoAcumulado)) { //si cabe el objeto
				
				pesoAcumulado = pesoAcumulado +objetos.get(i).peso;
				objetosEscogidos[objetos.get(i).index] = 1;
				valorAcumulado = valorAcumulado + objetos.get(i).valor;
			}
			i--;
		}
		
		SolucionMochila sol = new SolucionMochila(objetosEscogidos,pesoAcumulado,valorAcumulado);
		
		return sol;
	}
	

}
