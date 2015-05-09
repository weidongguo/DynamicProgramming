import java.util.Arrays;
public class maximumCommonSubstringTest{
	public static void main(String argv[])	{
		char X[] = {'c', 'a', 'b', 'c', 'c', 'b'}; 
		char Y[] = {'b', 'a', 'b', 'c', 'b', 'a'};

		System.out.println( Arrays.toString(X) + "\n"+ Arrays.toString(Y));
		System.out.println(maximumCommonSubstring.MCS(X,Y));
	}
}
