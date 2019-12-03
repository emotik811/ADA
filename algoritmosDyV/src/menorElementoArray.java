
public class menorElementoArray {

	public static int menorRecursivo(int [] v, int izq, int der) {
		
		if(izq==der) {
			return v[izq];
		}else {
			
			int medio = (izq + der)/2;
			return Math.min(menorRecursivo(v,izq,medio),menorRecursivo(v,medio+1,der));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] v = {345,876,342,123,57};
		
		System.out.println("El menor por DyV es "+menorRecursivo(v,0,v.length-1));
		int menor = v[0];
		for(int i = 0; i<v.length;i++)
		{
			if(v[i]<menor) {
				menor = v[i];
			}
		}
		
		System.out.println("EL menor por brute force es "+menor);
	}

}
