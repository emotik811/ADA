
public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean [][] vertices = {{false,true,false,true,false},
								{true,false,true,false,true},
								{false,true,false,true,false},
								{true,false,true,false,true},
								{false,true,false,true,false},
								};
								
		
		
		/*
		boolean [][] vertices = {{false,true,true,false},
								{true,false,true,true},
								{true,true,false,true},
								{false,true,true,false},
				};
		*/
		colorearKNodos problema = new colorearKNodos(5,vertices,3);
		problema.resolver();
		
		//System.out.println(problema.sePuedePintar(0, 1));
	}

}
