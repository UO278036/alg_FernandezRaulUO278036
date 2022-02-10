package algestudiante.p11;

public class Vector4 {
	static int[] v;
	final static int MAX_TAM = 10000000;
	public static void main(String[] args) {
		long t1, t2;
		int nRepeticiones = Integer.parseInt(args[0]);
		int s = 0;
		
		System.out.println("n\tt");
		
		for(int n=10; n<MAX_TAM; n = n * 3) {	 // Variamos el tamaño del problema		
			//Operaciones previas a la que quiero medir
			v = new int [n];
			Vector1.rellena(v);
			//Lanzo el contador de tiempo
			 t1 = System.currentTimeMillis();
			 
			 //Repeticiones para consegir suficiente tamaño en el tiempo de la operacion

			 for(int repeticiones = 0; repeticiones <nRepeticiones;repeticiones++) {
				 //Ejecuto lo que quiero medir
				  s=Vector1.suma(v); 		 
			 }
									
			 t2 = System.currentTimeMillis();					
			 long duracion = t2-t1;
		
			 System.out.println(n+"\t"+duracion+ "\t"+ s);
		}
	}
}
