
public class Ejercicio1 {
	
	public static int recursividad(int [] v,int izq, int der) {
		
		
		if(der==izq) {
			
			if (v[der]==der) {
				return der;
			}else {
				return -1;
			}
		} else {
			 int medio = (der + izq)/2;
			 if(v[medio]==medio) {
				 return medio;
			 }else {
				 if(v[medio]>medio) {
					 return recursividad(v,izq,medio);
				 }else  {
					 return recursividad(v,medio,der);
				 }
			 }
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int v [] = {-5,-3,-2,3,7,8,10};
		System.out.println(recursividad(v,0,v.length-1));
	}


}
