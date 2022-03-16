package algUO278036.p31;

public class Division4 {
	static long cont;

	public static boolean rec4 (int n)
	{
		if (n<=0) 
			cont++;
		else
		{ 
			cont++ ; // O(1)    
			for (int i=1;i<n;i++) {
				cont++;
			}
			rec4 (n/2);
			rec4 (n/2);
			rec4 (n/2);
			rec4 (n/2);//a = 4, b = 2, k = 1 => O(n^2)
		}
		return true;   
	}
	
	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		int nVeces= Integer.parseInt (arg [0]);
		boolean b=true;

		for (int n=1;n<=10_000_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec4 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);

		}  // for

	} 
}
