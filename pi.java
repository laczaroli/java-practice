package prog2;

class pi {
	public static void main(String[] args) {
		pi dpike = new pi();
		long start = System.currentTimeMillis();
		System.out.println(dpike.dpi(100000000)); // 10^6
		long end = System.currentTimeMillis();
		
		double x = (double) (end-start); 
		
		System.out.println(x/1000 + "mp");
		//1.592mp - 10 ^ 6
		//18.406mp - 10 ^ 7 
		//211.162mp - 10 ^ 8
	}
	public String dpi(int d)
	{
		double Sone = calc(d,1);
		double Sfour = calc(d,4);
		double Sfive = calc(d,5);
		double Ssix = calc(d,6);
		
		double sixtdpi = (4.0*Sone)-(2.0*Sfour)-Sfive-Ssix;
		
		
		sixtdpi = sixtdpi - (int) sixtdpi;
		
		if(sixtdpi < 0) sixtdpi += 1;
		
		String sb = "";
		
		Character[] Hexs = {'A','B','C','D','E','F'};
		
		while(sixtdpi != 0.0)
		{
			int jegy = (int) (16.0*sixtdpi);
			
			if(jegy < 10) sb = Integer.toString(jegy);
			else sb = Character.toString(Hexs[jegy-10]);
			
			sixtdpi = (16*sixtdpi) - StrictMath.floor(16.0*sixtdpi);
		}
		
		return sb;
	}
	
	public double calc(int d, int n)
	{
		double dkiszam = 0.0;
		for(int k = 0; k<=d; k++)
			dkiszam += (double)mod(d-k,16,(8*k+n))/(double)(8*k+n);
		return dkiszam - (int) dkiszam;
	}
	
	public static long mod(int n, int b, int k)
	{
		long r = 1;
		int t = 2;
		
		while(n >= t)
			t*=2;
		
		while(true)
		{
			if(n>=t)
			{
				r=(b*r) % k;
				n = n - t;
			}
			t = t/2;
			if(t >= 1)
			{
				r = (r*r) % k;
			} else break;
		}
		return r;
	}
}