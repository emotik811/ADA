
public class pruebaN3 {
	public static void f(long number )
	{
		int array [] = new int[(int) number];
		int suma = 0;
		int suma2 = 0;
		for(int i = 0; i<array.length-1;i++) {
			array[i] = 1;
			for(int j = i+1;j<array.length-1;j++)
			{
				suma = suma+array[j];
				for(int k=i+1; k<array.length-1;k++) {
					suma2 = suma2 + array[k];
				
				}
			}
			
		}
			
				
					
		
	}
}
