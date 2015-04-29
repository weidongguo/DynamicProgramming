public class rodCutting{
	
	static int maxRevenue(int r[], int price[],int n){
		int max = price[1] + r[n-1];	
		for(int i = 2; i <= n; i++){ // O(n)
			if( max < price[i] + r[n-i])//set the max revenue by comparing every single way of cutting the rod	
				max = price[i] + r[n-i]; 	
		}
		return max;
	}

	static void revenue(int price[], int n){
	/* r_n = max { p_i + r_n-i } for i from 1 to n*/
		int r[] = new int[n+1];
		r[0] = price[0]; //just 0; revenue for a length 0 rod is just $0
		r[1] = price[1]; //revenue of length 1 is always the price for length 1	
		System.out.print(r[1] + " ");
			
		for(int i = 2; i <= n; i++){ // O(n)
			r[i] = maxRevenue(r, price, i);  //O(n)
			System.out.print(r[i] + " ");	// max revenue for rod of length i
		}//O(n^2);
		
		
		System.out.println();
	}
}


	
