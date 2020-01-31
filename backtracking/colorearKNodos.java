
public class colorearKNodos {

		int nodos;
		boolean [][] vertices;
		int colores;
		int [] solucion;
		
		public colorearKNodos(int numero_nodos, boolean [][] array_vertices, int colores)
		{
			this.nodos = numero_nodos;
			this.vertices = array_vertices;
			this.colores = colores;
			this.solucion = new int [nodos];
		}
		
		public void imprimir()
		{
			for(int e : solucion)
			{
				System.out.println(e+" ");
			}
		}
		
		public void resolver() {
			
			if(bt(0)) {
				 System.out.println("Se puede resolver");
				 imprimir();
			}else {
				System.out.println("No se puede resolver");
			}
			
		}
		
		public boolean esSolucion(int indice) {
			
			return indice==nodos;
		}
		
		public boolean sePuedePintar(int indice, int color)
		{
			
			boolean resultado = true;
			int i = 0;
			while(resultado && i< vertices.length)
			{
				if(vertices[indice][i]==true)
				{
					resultado = solucion[i]!=color;
				}
				
				
				i++;
			}
			return resultado;
		}
		
		public boolean bt(int indice)
		{
			if(esSolucion(indice)) {
				return true;
			}
			
			boolean resuelto = false;
			int indice_color = 1;
			
			while(!resuelto && indice_color<=colores)
			{
				if(sePuedePintar(indice,indice_color))
				{
					solucion[indice] = indice_color;
					resuelto = bt(indice+1);
					if(!resuelto)
					{
						solucion[indice] = 0; //0 representa que no se ha pintado
					}
				}
				indice_color++;
			}
			
			return resuelto;
		}
}
