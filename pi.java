package prog2;

class pi {
	public static void main(String[] args) {
		pi dpike = new pi();
		System.out.print(dpike.dpi(1000000));
	}
	
	public double dpi(int d)
	{
		double Sone = calc(d,1);
		double Sfour = calc(d,4);
		double Sfive = calc(d,5);
		double Ssix = calc(d,6);
		
		double sixtdpi = (4.0*Sone)-(2.0*Sfour)-Sfive-Ssix;

		
		return sixtdpi - (int) sixtdpi;
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
