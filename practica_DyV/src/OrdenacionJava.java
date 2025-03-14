import java.util.ArrayList;
import java.util.List;

////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Juan Rosa Gonz�lez
// GRUPO: 2�A
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionJava extends Ordenacion {
    
	
   public static <T extends Comparable<? super T>> void ordenar(T v[]) {
        // A implementar por el alumno
	   
	   List<T> lista = new ArrayList<T>();
	   for(T elemento : v) {
		   
		   lista.add(elemento);
	   }
	   
	   lista.sort(null);
	   for(T elemento : lista) {
		   System.out.print(" "+elemento+" ");
	   }
   }


	// Peque�os ejemplos para pruebas iniciales.
	public static void main (String args[]) {
	
		// Un vector de enteros
		Integer vEnt[] = {3,8,6,5,2,9,1,1,4};
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = {'d','c','v','b'};
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}	
    
}
