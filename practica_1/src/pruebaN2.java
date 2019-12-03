
public class pruebaN2 {
	public static void f(long numero) {
		long suma = 0;
		long[] array = new long [(int) numero];
		for(int i = 0; i<array.length-1;i++)
		{
			array[i] = 1;
			
			
			for(int j = i+1; j<array.length;j++)
			{
				suma = suma + array[j];
			}
		}

				
	}
}
