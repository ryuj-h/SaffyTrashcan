import java.util.Scanner;

public class swea5215 {
	public static int N;
	public static int L;
	public static int Maxpoint;
	public static int points[] = new int [21];
	public static int caloriys[] = new int [21];
	
	public static void dfs(int depth, int sumpoint, int sumcalory) {
		if (depth == N) {
			Maxpoint = Math.max(Maxpoint,sumpoint);
			return;
		}
	
		//재료를 고른것과 안 고른것을 나누어서 탐색
		if (sumcalory + caloriys[depth] < L)
			dfs(depth+1, sumpoint + points[depth],sumcalory + caloriys[depth]);
		dfs(depth+1, sumpoint ,sumcalory);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Maxpoint = Integer.MIN_VALUE;
			N = sc.nextInt();
			L = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				int Point = sc.nextInt();
				int calory = sc.nextInt();
				points[i] = Point;
				caloriys[i] = calory;
			}
			dfs(0,0,0);

			System.out.printf("#%d %d\n",test_case,Maxpoint);
		}
	}
}
