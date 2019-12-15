package chapuzas;

import java.util.Arrays;

public class Chapuzas {

	public static void main(String[] args) {

		int [][] a = {{3,2},{22,11}};
		
		Arrays.sort(a);
		
		for(int i = 0; i<a.length;i++)
		{
			for(int j = 0; j<a[0].length;j++)
			{
				System.out.print(" "+a[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
