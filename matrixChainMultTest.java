public class matrixChainMultTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
	

	public static void main(String argv[])	{
		int p[] = {30, 35, 15, 5, 10, 20, 25};
		matrixChainMult.minNumOfMults(p);			
		int p2[] = {5, 4, 6, 2, 7};
		matrixChainMult.minNumOfMults(p2);

		int p3[] = {5,10,3,12,5,50};
		matrixChainMult.minNumOfMults(p3);
		
		int p4[] = {5,6,3,7,5,3,4};
		matrixChainMult.minNumOfMults(p4);
	
	}
}
