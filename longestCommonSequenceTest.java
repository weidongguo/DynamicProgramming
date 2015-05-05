import java.util.Arrays;
public class longestCommonSequenceTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
	
	static void printDIR(DIR c[][]){
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[i].length; j++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String argv[])	{
		char X[] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char Y[] = {'B', 'D', 'C', 'A', 'B', 'A'};	
		System.out.println( Arrays.toString(X) + "\n"+ Arrays.toString(Y));
		DIR b[][] = longestCommonSequence.longestCommonSequence(X,Y);
		printDIR(b);	
		System.out.println("Longest Common Sequence: "+ longestCommonSequence.decode(b,X));		

	}
}
