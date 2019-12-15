import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ***** Juan Rosa González*******
 *
 */

public class MochilaAV extends Mochila {

	class ratioObjeto implements Comparable<ratioObjeto> {
		
		int indice;
		int valor;
		double ratio;
		
		public ratioObjeto(int indice,int valor ,double ratio) {
			
			this.indice =indice;
			this.valor = valor;
			this.ratio = ratio;
		}
		
		@Override
		public int compareTo(ratioObjeto arg0) {
			if(this.ratio == arg0.ratio && this.valor == arg0.valor)
			{
				return 0;
			}else if(this.ratio== arg0.ratio && this.valor<arg0.valor) {
				return 1;
			}else if(this.ratio== arg0.ratio && this.valor>arg0.valor) {
				return -1;
			}else if(this.ratio<arg0.ratio) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	
	public SolucionMochila resolver(ProblemaMochila pm) {
		
  
		ratioObjeto [] ratios = new ratioObjeto[pm.getPesos().length];
		
		for(int i =0; i<pm.getPesos().length;i++) {
			ratios[i] = new ratioObjeto(i,pm.getValor(i),(double)pm.getValor(i)/pm.getPeso(i));
		}
		
		//IMPORTANTE: EL ORDEN DE ORCENACIÓN ES ASCENDENTE
		Arrays.sort(ratios);
		
		//Para este punto el array debería de estar ordenado correctamente (de forma ascendente)
		
		int valorAcumulado = 0;
		int pesoAcumulado = 0;
		int [] objetosEscogidos = new int [pm.getPesos().length]; 
		
		//como está ordenado ascendentemente, empezamos de arriba a abajo
		int i =0;
		
		while(i <= ratios.length-1 && pesoAcumulado<pm.getPesoMaximo()) {
			if(pm.getPeso(ratios[i].indice)<= (pm.getPesoMaximo()-pesoAcumulado)) { //si cabe el objeto
				pesoAcumulado = pesoAcumulado + pm.getPeso(ratios[i].indice);
				objetosEscogidos[ratios[i].indice] = 1;
				valorAcumulado = valorAcumulado + pm.getValor(ratios[i].indice);
			}
			i++;
		}
		
		SolucionMochila sol = new SolucionMochila(objetosEscogidos,pesoAcumulado,valorAcumulado);
		
		return sol;
	}
	

}
