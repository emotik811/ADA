////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Juan Rosa González
// GRUPO:
////////////////////////////////////////////////////////////////////////////////////////////



public class OrdenacionRapida extends Ordenacion {
  
	
	
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
	    ordRapidaRec(v, 0, v.length-1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con 
	// una implementación recursiva del método de ordenación rápida.	
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
	    
		if(izq < der) {
			int s = partir(v,izq,der);			
			ordRapidaRec(v,izq,s-1);
			ordRapidaRec(v,s+1,der);
		}
		
	}
	   
   public static <T extends Comparable<? super T>> int partir(T v[],  int izq, int der) {
	   	T pivote = v[der];
	   	int i = izq-1;
	   	for(int j = izq; j<der;j++)
	   	{
	   		if(v[j].compareTo(pivote)<=0) {
	   			i++;
	   			intercambiar(v,i,j);
	   		}
	   	}
	   	
	   	intercambiar(v,i+1,der);	   
 	    return i+1;    	
   }

	// Pequeños ejemplos para pruebas iniciales.
	public static void main (String args[]) {
	
		// Un vector de enteros
		//Integer vEnt[] = {3,8,6,5,2,9,1,1,4};
		Integer vEnt[] = {17,36,10,5,17};
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = {'d','c','v','b'};
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}	
    
}
