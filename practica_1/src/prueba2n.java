
public class prueba2n {
	
	public static int f(int numero)
	{
		if (numero <= 1) return numero;
		return f(numero -2) + f(numero -1);
	}

}
