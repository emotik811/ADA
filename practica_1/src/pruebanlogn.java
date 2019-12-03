public class pruebanlogn {
	public static int f(long n) {
		int suma = 0;
		for (int j=0; j<n; j++) {
			for (int i=1; i<=n; i=i*2) {
				suma++;			
			}
		}
		return suma;
	}
}