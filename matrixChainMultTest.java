public class matrixChainMultTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
	
	static void printm(int m[][]){
		for(int i = 1; i < m.length; i++){
			for(int j = 1; j < m[i].length; j++){
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String argv[])	{
		int p[] = {30, 35, 15, 5, 10, 20, 25};
		int m[][] = matrixChainMult.minNumOfMults(p);			
		printm(m);
		int p2[] = {5, 4, 6, 2, 7};
		m = matrixChainMult.minNumOfMults(p2);
		printm(m);	
	
	}
}
