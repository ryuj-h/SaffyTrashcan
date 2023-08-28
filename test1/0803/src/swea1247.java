import java.util.ArrayList;
import java.util.Scanner;

class Pos{//위치 정보..
	public int x,y;
	Pos(int x, int y){
		this.x= x;
		this.y= y;
		}
	public int getdistanceTo(Pos p2) {// p2까지의 거리
		int res = Math.abs(this.x - p2.x) + Math.abs(this.y - p2.y);
		return res;
	}
}

public class swea1247 {

	public static Pos home = new Pos(0,0);
	public static Pos company = new Pos(0,0);
	public static Pos map[] = new Pos[100];
	public static boolean visited[] = new boolean[100];
	public static int N;
	public static int mindistance = Integer.MAX_VALUE;
	
	//집과 회사를 제외한 나머지 부분을 탐색하여 집과 회사의 거리를 더해서 판단
	public static void dfs(int index,int curr,int distance) {		
		if (index == N)
		{
			mindistance = Math.min(mindistance, distance + map[curr].getdistanceTo(home));
			return;
		}
		for(int i= 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] =true;
			if (index == 0) {
				curr = i;
				distance = map[i].getdistanceTo(company);
			}
			dfs(index + 1, i, distance + map[curr].getdistanceTo(map[i]));
			visited[i] =false;
			
		}
		
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for (int i =0 ; i< 12;i++) {
			map[i] = new Pos(0,0);
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			mindistance = Integer.MAX_VALUE;
			
			for (int i = 0; i < N + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if (i == 0) {
					company.x = x;
					company.y = y;
				}
				else if (i == 1) {
					home.x = x;
					home.y = y;
				}
				else {
					map[i-2].x = x;
					map[i-2].y = y;
				}
			}
			dfs(0,0,0);
			System.out.printf("#%d %d\n",test_case,mindistance);
		}
	}
}
