package algUO278036p32;

public class Tromino {
	private int[][] tablero;
	
	private static final int CASILLA_HUECO = 0;
	private static final int CASILLA_VACIA = -1;
	private int cas_rellena = 1;
	
	public static void main (String arg []) 
    {
        Tromino t;
        long t1,t2,cont;
        int nVeces= Integer.parseInt (arg [0]);
        boolean b=true;

        for (int n=4;n<=10000;n*=2)
        {
            t = new Tromino(n, 1, 1);
            t1 = System.currentTimeMillis ();

            for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
            { 
                t.tromino(n, 1, 1, 0, 0);
            } 

            t2 = System.currentTimeMillis ();

            System.out.println (b+" n="+n+ "TIEMPO="+(t2-t1)+"nVeces="+nVeces);

        }
    }
	
	public Tromino(int tam,int x,int y) {
		//Creamos el tablero del tamaño pasado como parametro
		tablero = new int[tam][tam];
		//Rellenamos el tablero de casillas vacias -1
		for(int i=0; i < tam;i++) {	
			for(int j=0; i<tam;i++) {
				tablero[i][j] = CASILLA_VACIA;
			}
		}
		// Asignamos el hueco al tablero
		tablero[x][y] = CASILLA_HUECO;
		
		
		
	}
	
	public void Show() {
		for(int i=0; i<tablero.)
		
	}
	
	// Podemos pasar directamente las direcciones del hueco como parametro para 
	// no tener que buscarlo 
	public void resuelveTromino(int[][] tablero,int tam, int x, int y, int cordx, int cordy) {
		int mCuadrante = tam/2;
		int m1 = cordx + mCuadrante -1;
		int m2 = cordy + mCuadrante -1;
		@SuppressWarnings("unused")
		int faltax = 0;
		@SuppressWarnings("unused")
		int faltay = 0;
		// Buscamos el hueco en el tablero
//		for(int i=0; i<tablero.length;i++) {
//			for(int j=0; j<tablero.length;j++) {
//				if(tablero[i][j] == 0) {
//					faltax = i;
//					faltay = j;
//				}
//			}				
//		}
		//------------------------------------------
		//Resolvemos caso base(suponemos long 2 si no recursivo)
		if(tam == 2) {
			for(int i=0; i<tablero.length;i++) {
				for(int j=0; j<tablero.length;j++) {
					if(tablero[i][j] != CASILLA_HUECO) {
						tablero [i][j] = CASILLA_VACIA;
					}
				}
			}
		}
		//---------------------------------------------------
		if(tam >=4) {
			int cuadrante1x = m1; 	
			int cuadrante2x = m1;
			int cuadrante3x = m1+1;
			int cuadrante4x = m1+1;
			int cuadrante1y = m2;
			int cuadrante2y = m2;
			int cuadrante3y = m2+1;
			int cuadrante4y = m2+1;
			
			if(x < m1 && x <m2) {
				cuadrante1x = x;
				cuadrante1y = y;
				tablero[m1][m2+1] = cas_rellena;
				tablero[m1+1][m2] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
											
			}else if (x <= m1 && x > m2) {
				cuadrante2x = x;
				cuadrante2y = y;
				tablero[m1][m2] = cas_rellena;
				tablero[m1+1][m2] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
			}else if (x > m1 && x <= m2) {
				cuadrante3x = x;
				cuadrante3y = y;
				tablero[m1][m2] = cas_rellena;
				tablero[m1][m2+1] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
			}else {
				cuadrante3x = x;
				cuadrante3y = y;
				tablero[m1][m2] = cas_rellena;
				tablero[m1][m2+1] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;	
			}
			resuelveTromino(tablero,mCuadrante,cuadrante1x,cuadrante1y,cordx,cordy);
			resuelveTromino(tablero,mCuadrante,cuadrante2x,cuadrante2y,cordx,cordy+mCuadrante);
			resuelveTromino(tablero,mCuadrante,cuadrante3x,cuadrante3y,cordx+mCuadrante,cordy);
			resuelveTromino(tablero,mCuadrante,cuadrante4x,cuadrante4y,cordx+mCuadrante,cordy+mCuadrante);					
		}  			
	}
		
}

