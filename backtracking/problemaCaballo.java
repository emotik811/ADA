
public class problemaCaballo {



	int tam;
	int[][] tablero;
	int [] movX = {2,1,-1,-2,-2,-1,1,2};
	int [] movY = {1,2,2,1,-1,-2,-2,-1};

	public problemaCaballo(int tam)
	{
		this.tam = tam;
		tablero = new int [tam][tam];
		tablero[0][0] = 1;
	}

	public void imprimir()
	{
		for(int i = 0; i<tablero.length;i++)
		{
			for(int j = 0;j<tablero.length;j++)
			{
				System.out.print(tablero[i][j]+" ");
			}
			System.out.println(" ");
		}


	}
	public void resolver(int x, int y)
	{
		if(bt(x,y,1))
		{
			System.out.println("Se puede resolver, genio");
			this.imprimir();
		}else {
			System.out.println("O lo que has hecho es una puta mierda o no se puede resolver, genio");
			this.imprimir();
		}
	}

	//comprueba que se puede saltar a una posicio
	public boolean se_puede(int x, int y)
	{

		return (x>=0 && x<tam && y>=0 && y<tam && tablero[x][y]==0);
	}

	public boolean esSolucion(int k) {

		return k==tam*tam;
	}

	public boolean bt(int x, int y, int k) 
	{
		// condicion pricipal
		
	
		
		if(esSolucion(k))
		{
			return true;
		}else {

			int indice_mov = 0;
			boolean exito = false;

			while(!exito && indice_mov<movX.length) {

				int nuevaX = x + movX[indice_mov];
				int nuevaY = y + movY[indice_mov];

				if(se_puede(nuevaX,nuevaY))
				{
					tablero[nuevaX][nuevaY] = k+1;
					exito = bt(nuevaX,nuevaY,k+1);
					if(!exito)
					{
						tablero[nuevaX][nuevaY]=0;
					}
				}
				indice_mov++;
				
				
			}
			return exito;
		}



	}
}


