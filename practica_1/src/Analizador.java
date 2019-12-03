import java.util.ArrayList;
import java.util.List;

public class Analizador {

	public static int obtenerMagnitud(long n) {	
		
		int aux = String.valueOf(n).length();
		//System.out.println("Valor "+valor+" Aux "+aux);
		int respuesta = (int) Math.pow(10, aux-1);
		return respuesta;
	}
	
	public static long obtenerEntradaBase(){
		// obtiene un array de tiempos y las entradas correspondientes
		// tiempo en nanosegundos tiempo 1.000.000.000 = 1 segundo
		double t_maximo = 0.3 * Math.pow(10, 9);
		double t_suficiente= 50000000;
		double t_operacion = 0;
		
		System.out.println("Obteniendo datos para T_SUFICIENTE: "+t_suficiente);
		long n = 1;
		long c = 1;
		long multiplo = 1;
		Temporizador temp_total = new Temporizador();
				
		temp_total.iniciar();
		while(t_operacion < t_suficiente && n<500000000000000L) {
			
			//INCREMENTEO A USAR
			c++;
			if(c>9) {
				c=1;
				multiplo = multiplo *10;
			}
			n = c * multiplo;
			
			
			Algoritmo.f(1); //carga, quizás sea conveniente quitarlo
			Temporizador temp_operacion = new Temporizador();
			temp_operacion.iniciar();
			Algoritmo.f(n);
			temp_operacion.parar();
			t_operacion = (double)temp_operacion.tiempoPasado();
			System.out.println("Tiempo: " + t_operacion+" tiempo suf "+t_suficiente+" con entrada "+n);
			
		}
		
		temp_total.parar();
		
		return n;
		
	}
	
	public static double[][] obtenerArrayTiempos(long entrada){
		
		int tamanio_respuesta=4;
		int repeticiones_calculo = 3;
		
		 //[0 entradas, 1 tiempos]
		long [] entradas = obtenerArrayEntradas(entrada, tamanio_respuesta);
		double [][] respuesta = new double [entradas.length][2];
		System.out.println("array de entradas listo Para entrada n inicial = "+entrada);
		
		for (int i = 0; i<entradas.length; i++)
		{
			double t_operacion = 0;
			long n = entradas[i];
			for(int j = 0; j<repeticiones_calculo;j++)
			{
				Temporizador temp_operacion = new Temporizador();
				temp_operacion.iniciar();
				Algoritmo.f(n);
				temp_operacion.parar();
				t_operacion = t_operacion +temp_operacion.tiempoPasado();
			}
			
			respuesta[i][0] = entradas[i];
			respuesta[i][1] = t_operacion/repeticiones_calculo;
			System.out.println("Para entrada "+entradas[i]+"/"+respuesta[i][0]+"se ha tardado "+ respuesta[i][1]);
		}
		
			
		
		return respuesta;
	}
	
	public static long [] obtenerArrayEntradas(long n, int tamanio_respuesta) {
		
		
		int aux_magnitud = obtenerMagnitud(n) /tamanio_respuesta;
		long [] entradas = new long [tamanio_respuesta];
		entradas[tamanio_respuesta/2] = n;
		for(int i = (tamanio_respuesta/2)+1;i<entradas.length;i++) {
			 entradas[i] = entradas[i-1] + aux_magnitud;
		}
		for(int i = (tamanio_respuesta/2)-1; i>= 0; i--) {
			entradas[i]=entradas[i+1]-aux_magnitud;
		}
		
		
		//int[] entradas = {n/2,n,n*2};
		
		return entradas;
	}
	
	// CODIGOS PARA TIEMPOS/O(lo que sea)
	
	public static double[] ratio1 (double[][] valores) {
		
		double [] respuesta  = new double [valores.length];
		for(int i = 0; i< valores.length; i++)
		{
			respuesta [i] = valores[i][1];
		}
		
		/*
		System.out.print("Resultado O1 ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}
	
	public static double[] ratiologn (double[][] valores)
	{
		 double [] respuesta = new double [valores.length];
		
		 for(int i = 0; i<valores.length;i++)
		 {
			 respuesta [i] = valores[i][1]/(Math.log(valores[i][0]));
		 }
		 	/*
			System.out.print("Resultado long ");
			for(double elemento : respuesta) {
				System.out.print(elemento+" ");
			}
			System.out.println(" ");
			*/
		 return respuesta;
	}
	
	public static double[] ration (double[][] valores)
	{
		double respuesta [] = new double[valores.length];
		
		for(int i = 0; i<respuesta.length;i++)
		{
			respuesta[i] = valores[i][1]/valores[i][0];
		}
		/*
		System.out.print("Resultado n ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}
	
	public static double[] rationlog (double[][] valores)
	{
		double respuesta [] = new double[valores.length];
		
		for(int i = 0; i<respuesta.length;i++)
		{
			double log = valores[i][0] * Math.log(valores[i][0]);
			respuesta[i] = valores[i][1]/log;
		}
		
		/*
		System.out.print("Resultado nlogn ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}

	public static double[] ration2 (double[][] valores)
	{
		double respuesta [] = new double[valores.length];
		
		for(int i = 0; i<respuesta.length;i++)
		{
			double k = valores[i][0] * valores[i][0];
			respuesta[i] = valores[i][1]/k;
		}
		/*
		System.out.print("Resultado n2 ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}
	
	public static double[] ration3 (double[][] valores)
	{
		double respuesta [] = new double[valores.length];
		
		for(int i = 0; i<respuesta.length;i++)
		{
			double k = valores[i][0];
			double q = k*k*k;
			respuesta[i] = valores[i][1]/q;
		}
		/*
		System.out.print("Resultado n3 ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}

	public static double[] ratio2n (double[][] valores) {
		
		double [] respuesta = new double [valores.length];
		
		for(int i = 0; i<respuesta.length; i++) {
			
			respuesta [i] = valores[i][1] /(Math.pow(2, valores[i][0]));
		}
		/*
		System.out.print("Resultado 2n ");
		for(double elemento : respuesta) {
			System.out.print(elemento+" ");
		}
		System.out.println(" ");
		*/
		return respuesta;
	}
	
	// VARIANZA
	public static double varianza (double[] valores)
	{
		double sum = 0;
		double media;
		for(int i = 0; i<valores.length;i++)
		{
			sum = sum + valores[i];
		}
		
		media = sum/valores.length;
		
		double sumatorio = 0;
		
		for (int i = 0;i< valores.length;i++) {
			double a = valores[i]- media;
			sumatorio = sumatorio + (a*a) ;
		}
		
		double var = sumatorio/valores.length;
		//System.out.println("La varianza calculada ha sido: "+ var);
		return var;
	}
	
	//COMPARACION
	
	public static String aproximacion(double[][] valores) {
		
		String resultado;
		int indice = 0;
		double varianza = varianza(ratio1(valores));
	
		
		while( varianza>1 && indice<7)
		{
			indice ++;
			System.out.println("Indice "+indice);
			varianza = nextVarianza(valores,indice);
			
		}
		
		
		switch(indice)
		{
			case 0:
				resultado = "1";
				break;
			case 1:
				resultado = "LOGN";
				break;
			case 2:
				resultado ="N";
				break;
			case 3: 
				resultado = "NLOGN";
				break;
			case 4:
				resultado = "N2";
				break;
			case 5:
				resultado = "N3";
				break;
			case 6: 
				resultado ="2N";
				break;
			default:
				resultado = "NF";
		}
		
		return resultado;
	}
	
	public static double nextVarianza(double[][] valores, int indice)
	{
		double resultado = 0;
		
		switch (indice) {
		case 0:
			resultado = varianza(ratio1(valores));
			break;
		case 1:
			resultado = varianza(ratiologn(valores));
			break;
		case 2: 
			resultado = varianza(ration(valores));
			break;
		case 3:
			resultado = varianza(rationlog(valores));
			break;
		case 4: 
			resultado = varianza(ration2(valores));
			break;
		case 5: 
			resultado = varianza(ration3(valores));
			break;
		case 6: 
			resultado = varianza(ratio2n(valores));
			break;
		default:
			resultado = -1;
			break;
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
	
		List<String> respuestas= new ArrayList<String>();
		Temporizador tiempo_total= new Temporizador();
		tiempo_total.iniciar();
		boolean expo = false;
		Temporizador facto = new Temporizador();
		facto.iniciar();
		Algoritmo.f(10);
		facto.parar();
		
		if(facto.tiempoPasado()>12000000L)
		{
			expo = true;
			System.out.println("N!");
			
		}
		if(!expo) {
			
			int [] res =  {0,0,0,0,0,0,0};
			while(!expo && tiempo_total.tiempoPasado()<3000000000L)
			{
				double [][] tiempos = obtenerArrayTiempos(obtenerEntradaBase());
				String aproxi = aproximacion(tiempos);
				
				if(aproxi=="1") {res[0]++;}
				if(aproxi=="LOGN") {res[1]++;}
				if(aproxi=="N") {res[2]++;}
				if(aproxi=="NLOGN") {res[3]++;}
				if(aproxi=="N2") {res[4]++;}
				if(aproxi=="N3") {res[5]++;}
				if(aproxi=="2N") {res[6]++;}
				
				respuestas.add(aproxi);
				
			}
			tiempo_total.parar();
			
			int mayor = 0;
			for(int i = 0; i<res.length;i++) {
				if(res[i]>res[mayor]) {
					mayor = i;
				}
			}
			
			String resultado;
			switch(mayor)
			{
				case 0:
					resultado = "1";
					break;
				case 1:
					resultado = "LOGN";
					break;
				case 2:
					resultado ="N";
					break;
				case 3: 
					resultado = "NLOGN";
					break;
				case 4:
					resultado = "N2";
					break;
				case 5:
					resultado = "N3";
					break;
				case 6: 
					resultado ="2N";
					break;
				default:
					resultado = "NF";
			}
			
			System.out.println(resultado);
			/*
			for(String elemento : respuestas) {
				
				System.out.print(elemento+" ");
			}
			*/
		}

		
	}
			
	
}

