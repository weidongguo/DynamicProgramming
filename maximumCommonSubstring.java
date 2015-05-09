/* c[i,j] = c[i-1, j-1] + 1 <- if X[i] = Y[j]
	 c[i,j] = 0 , otherwise
 */
		

public class maximumCommonSubstring{
	public static String MCS(char X[], char Y[]){
		int c[][] = new int[X.length+1][Y.length+1];	//includes the empty subsequence	
		
		/* initialization of c[][] */
		for(int m = 0; m <= X.length; m++) 
			c[m][0] = 0; 
		for(int n = 0; n <= Y.length; n++)
			c[0][n] = 0; //length of LCS for an empty seq and any other seq 
	  /* end of initialization*/
		
		for(int i = 1 ; i <= X.length; i++){
			for(int j = 1 ; j <= Y.length; j++){
					if( X[i-1] == Y[j-1] )//the array starts at index 0
						c[i][j] = c[i-1][j-1] + 1;
					else
						c[i][j] = 0;	
		
			}
		}//Complexity: Run time = O(m*n);
		printTable(c);

		return decode(c, X);
	}
	
	public static String decode(int c[][], char X[]){
		int i = c.length - 1;
		int j = c[i].length - 1;
		int max = c[i][j];
		int p = 0 , q = 0; 
		String str = new String("");	
		for(; i >= 0; i--){
			for(j = c[i].length-1; j >= 0; j--){
					if( c[i][j] > max){
						max = c[i][j];	
						p = i;
						q = j;
					}
			}
		}
		while( p!=0 && q!=0){
			if( c[p][q] == 0)
				break;
			str =  X[p-1] + str; 
			p--;
			q--;
		}

		return "the maximum common subtring is "+str;
	}
	static void printTable(int t[][]){
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				System.out.print(t[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}

