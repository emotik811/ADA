package programacionDinamica;

public class CambioMonedas {

	public static int cambioMonedas(int[] monedas, int cantidad) {

		// lo primero es formar la tabla tabla[moneda][cantidad a pagar]

		int[][] tabla = new int[monedas.length][cantidad + 1];

		// caso base
		for (int i = 0; i < monedas.length; i++) {
			tabla[i][0] = 0;
		}

		for (int i = 0; i < monedas.length; i++) {
			for (int j = 1; j < tabla[i].length; j++) { // como para j = 0 se corresponde con 0 evitamos la redundancia

				// NOS BASTA CON CALCULAR "MANUALMENTE LA PRIMERA MONEDA"
				// caso1: no se puede calcular
				// ¿por qué -1 y no 0? Supon por ejemplo que tienes que pagar 3 euros pero no
				// existen monedas de 1 euro
				if (monedas[i] > j) {
					if (i == 0) {
						tabla[i][j] = -1;
					} else {
						tabla[i][j] = tabla[i - 1][j];
					}

					// caso2:
				} else if (i == 0) {
					tabla[i][j] = 1 + tabla[0][j - monedas[0]];
					// caso3: exceso
				} else {
					tabla[i][j] = Math.min(tabla[i - 1][j], 1 + tabla[i][j - monedas[i]]);
				}

			}

		}

		return tabla[monedas.length - 1][cantidad];
	}

	// probar con condicional para caso 1 y 3

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] monedas = { 2, 4, 6 };
		int cantidad = 8;

		System.out.println("Como mimino podemos pagar con: " + cambioMonedas(monedas, cantidad));
	}

}
