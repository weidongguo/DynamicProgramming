public class matrixChainMult{
	 public static int[][] minNumOfMults(int p[]){ 
		/* A_i has dimension p[i-1] X p[i] , e.g. A_1 has p[0] X p[1]
		 * A_(i+1) has dimension p[i] X p[i+1],
		 * then A_i X A_(i+1) has dimension p[i-1] X p[i+1]
		 * and cost p[i-1] * p[i] * p[i+1]
		 */ 
		int n = p.length - 1; //that many matrices
		int m[][] = new int[n+1][n+1]; //index 0 not used	
		int s[][] = new int[n+1][n+1]; //index 0 not used
		for(int i = 1 ; i <= n; i++){ //initialize diagonal to 0's
			m[i][i] = 0;	
			s[i][i] = 0;			
		}
		int q;
		for( int d = 2; d <= n; d++){//going through every diagonal from mid to the right end
			for(int i = 1; i <= n + 1 - d; i++){
				int j = i + d - 1	;
/* now compute m[i,j] = min_k{ m[i,k], m[k+1, j], p[i-1] * p[k] * p[j]}
 */ 
				for(int k = i, min = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j]; k <= j-1; k++){
					q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if( q < min)
						min = q;
					m[i][j] = min;
					s[i][j] = k;	
				}
			}
		}
		return m;	
	}
}
