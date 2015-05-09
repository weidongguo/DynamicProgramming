import java.util.ArrayList;
public class rodCuttingTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}

	public static void main(String argv[])	{
	/* length i = array index i
	 * price p_i = price[i] */
		int price[] = {0, 1, 5, 8, 9, 10}; //length 0 is not used
		rodCutting.revenue(price, 5, 0);
		int price2[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		rodCutting.revenue(price2, price2.length-1, 1);
		
		int price3[] = {0, 1, 4, 5, 9, 10, 12, 15, 18, 19, 20};
		rodCutting.revenue(price3, price3.length-1, 1);

	}
}
