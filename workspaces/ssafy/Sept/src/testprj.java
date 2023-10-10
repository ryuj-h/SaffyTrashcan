import java.util.Scanner;

/**
 * 
 * 
 * 
 * @author SSAFY
 *
 */


public class testprj {

	static int N, M, solution = 0;
	static long Solution2;
	static int arr[] = {1,1,2};//파 노 빨
	
	static int DP[];
	
	//점화식 규칙을 알아보기 위해 구현함
	//2	5 12 29 70 169 408
	public static void dfs(int depth,int lenth) {
		if (lenth >= M) {
			if (lenth == M)
			{
				solution++;
			}
			return;
		}
		for(int i =0 ; i < 2;i++) {
			dfs(depth + 1 , lenth + arr[i]);
		}
	}
	
	
	
	//2번
	public static long makeDP(int n) {
		for(int i =3; i <= n; i++) {
			DP[i] = DP[i-1] * 2 + DP[i-2];
		}
		return DP[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;) {
			M = sc.nextInt();
			DP = new int [M+1];
			DP[1] = 2;
			DP[2] = 5;
			
			Solution2 = makeDP(M);
			
			//dfs(0,0);
			System.out.println(Solution2);
		}
	}

}
