package algUO278036p5;


public class Levensthein {
	int [][] matriz;
	String[] palabra1;
	String[] palabra2;
	
	public static void main (String arg []) 
    {
		Levensthein lev = new Levensthein("BARCAZAS","ABRACADABRA");	
		lev.distanciaLevensthein();
		System.out.println("Solución de numero de cambios " +lev.distanciaLevensthein()+ "\n");
		lev.show();
    }
	public Levensthein(String uno, String dos) {
		palabra1 = new String[uno.length() +1];
		palabra2 = new String[dos.length() +1];
		
		matriz = new int[palabra1.length][palabra2.length];
		
		palabra1[0] = "";
		palabra2[0] = "";
		int i=1;	
		for(String letra : uno.split("")) {
			palabra1[i] = letra;
			i++;
		}
		int j=1;
		for(String letra : dos.split("")) {
			palabra2[j] = letra;
			j++;
		}
	}
	
	private int distanciaLevensthein() {
		for(int i=0; i< palabra1.length; i++) {
			matriz[i][0] = i;
		}
		for(int i=0; i< palabra2.length; i++) {
			matriz[0][i] = i;
		}
		for(int i=1; i< palabra1.length; i++) {
			for(int j=1; j<palabra2.length; j++) {
			if(palabra2[j].equals(palabra1[i])) {
				matriz[i][j] = matriz[i-1][j-1];
			}
			else {		
				matriz[i][j] = Math.min(matriz[i-1][j-1],matriz[i-1][j]);
				matriz[i][j] = Math.min(matriz[i][j],matriz[i][j-1])+1;
			}
			}
		}
		
		int result = matriz[palabra1.length-1][palabra2.length-1];
		
		return result;
	}
	
	public  void show() {
		for(int j=0; j<matriz[0].length;j++) {		
			for(int i=0;i<matriz.length;i++) {		
				System.out.print(matriz[i][j] +"\t") ;
			}
			System.out.println() ;
		}
		System.out.println("---------------------------------");
	}
}
