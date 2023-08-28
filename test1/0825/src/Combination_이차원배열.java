import java.util.Arrays;

public class Combination_이차원배열 {
	
	static int R= 3, C =4;
	
	static int [][] arr = {
			{1,2,3,4},
			{5,6,7,8},
			{7,8,9,0}
	};
	
	static int K = 3;
	static int picked[] = new int [K];
	
	
	
	private static void combination(int cnt, int startR,int startC) {
		if (cnt == K) {
			System.out.println(Arrays.toString(picked));
		}
	}
	
	
	public static void main(String args[]) {
		
	}
}
