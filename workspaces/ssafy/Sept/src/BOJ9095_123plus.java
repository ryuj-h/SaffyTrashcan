import java.util.Scanner;

/**
 * 풀이방법
 * 암만 봐도 DP같으나 점화식 구하는 방법을 모르기에
 * dfs를 통해서 조금 구해놓고 규칙을 찾아보자
 * 
 * @author SSAFY
 * 
 * 1 2 4 7 13 24
 * 
 * 점화식
 * DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
 */


public class BOJ9095_123plus {
	static long DP[];
	static int T,N,Solution = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i =0 ;i < T; i++) {
			N = sc.nextInt();

			DP = new long[N + 3];
			DP[0] = 1;
			DP[1] = 1;
			DP[2] = 2;
			for(int i = 3; i <= N;i++) {
				DP[i] = DP[i-1] + DP[i-2]+ DP[i-3];
			}
			System.out.println(DP[N]);	
		}
	}
}

/*
public class BOJ9095_123plus {
	static int T,N,Solution = 0;
	
	public static void dfs(int sum) {
		if(sum >= N) {
			if (sum == N) {
				Solution++;
			}
			return;
		}
		for(int i = 1; i <= 3; i++) {
			dfs(sum + i);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i =0 ;i < T; i++) {
			Solution = 0;
			N = sc.nextInt();
			dfs(0);
			System.out.println(Solution);
		}
	}
}
*/