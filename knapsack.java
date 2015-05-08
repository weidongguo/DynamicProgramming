public class knapsack{
	public static int[][] knapsack(int[]v,int[]w,int n, int totalWeight){
		int c[][] = new int[n+1][totalWeight+1];
		for(int i = 0; i <= totalWeight; i++)
			c[0][i] = 0; // no items to steal, no value	
		
		for(int i = 1; i <= n; i++){
			c[i][0] = 0; // when total weight is 0, can't take any items
			for(int j = 1; j<= totalWeight; j++){ //j = totalWeight for subproblem
				/*different total weight makes up a new subproblem*/	
				if(w[i-1] > j)
					c[i][j] = c[i-1][j]; //do not take the item i
				else { // w[i] < j
					//c[i,j] = 	max{ (c[ i-1 ][ j-w[i] ] + v[i]), c[i-1][j]
					if( c[ i-1 ][ j-w[i-1] ] + v[i-1] > c[i-1][j]){
							//value if take the item  > value if not take the item	
						c[i][j] = c[ i-1 ] [ j-w[i-1] ] + v[i-1];	
					}
					else // value if take the tiem < value if not take the item
						c[i][j] = c[i-1][j];
				}
			}
		}
		return c;
	}//runtime is O( n * totalWeight ); 
	
	public static void trace(int c[][],int w[]){
		System.out.print("\nPlease take items : ");	
		int row = c.length-1;
		int col = c[row].length-1 ;
		while( row!= 0 && col !=0)	{
				if( c[row-1][col] == c[row][col]) // means not take item
						row--;	
				else{ // item is taken;
					System.out.print(row + " ");	
					row--;
					col = col - w[row];	
				}
		}
		System.out.println("\nThe Optimal Value is " + c[c.length-1][c[0].length-1] );
	}
}	

/* note: w[i-1] is used because the w array starts with index 0 
 * so w[i-1] is actually refering to the weight of the ith item
 * if the concept of 0th item doesn't exist 
 *
 * similarly, v[i-1] is used too to represent value of the ith item 
 */
