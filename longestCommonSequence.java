enum DIR{
	DIAG, 
	UP,
	LEFT;
}

/* c[i,j] = c[i-1, j-1] + 1 <- if X[i] = Y[j]
	 c[i,j] = max{c[i-1, j], c[i, j-1] } <- if X[i]!=[j] 
	 where c[i,j] denotes the length of the longest common sequence
	 for X[i] and Y[j],  and i and j denotes the length of the 
	 sequence respectively	 	 
 */
		

public class longestCommonSequence{
	public static DIR[][] longestCommonSequence(char X[], char Y[]){
		int c[][] = new int[X.length+1][Y.length+1];	//includes the empty subsequence	
		DIR b[][] = new DIR[X.length+1][Y.length+1];	//encodes what is thelongest common sequence
		
		/* initialization of c[][] */
		for(int m = 0; m <= X.length; m++) 
			c[m][0] = 0; 
		for(int n = 0; n <= Y.length; n++)
			c[0][n] = 0; //length of LCS for an empty seq and any other seq 
	  /* end of initialization*/
		
		for(int i = 1 ; i <= X.length; i++){
			for(int j = 1 ; j <= Y.length; j++){
					if( X[i-1] == Y[j-1] ){//the sequence array starts at index 0
						c[i][j] = c[i-1][j-1] + 1;
						b[i][j] = DIR.DIAG; //where a match is found
					}
					else if( c[i-1][j] >= c[i][j-1]){
						c[i][j] = c[i-1][j]; 	
						b[i][j] = DIR.UP;
					}
					else{
						c[i][j] = c[i][j-1];
						b[i][j] = DIR.LEFT;	
					}
			}
		}//Complexity: Run time = O(m*n);
		printTable(c);
		return b;
	}
	
	public static String decode(DIR [][] b, char X[]){
		int i = b.length - 1;
		int j = b[i].length - 1;
		String str = new String("");	
		while( i!=0 && j !=0){
			if(b[i][j] == DIR.DIAG){ //b is a table that starts with index 0
				str = (X[i-1]) + str; //X is an seq that starts with index 1, so i-1 when i is the index for the table
				i--;
				j--;
			}
			else if(b[i][j] == DIR.UP)
				i--;
			else //DIR.LEFT
				j--;		
		}
		return str;
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

