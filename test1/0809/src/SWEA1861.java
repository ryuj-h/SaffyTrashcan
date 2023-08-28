
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
class SWEA1861
{
	static int N ;
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int roomnumber;
	static int max = Integer.MIN_VALUE;
	
	public static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<int[]>(); 
		q.offer(new int []{x,y,1});
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			int currx = curr[0];
			int curry = curr[1];
			int dist = curr[2];
			
			if (dist > max) {
				max = dist;
				roomnumber = map[y][x];
			}else if (dist == max) {
				if ( map[y][x] < roomnumber) {
					roomnumber = map[y][x];
				}
			}
			
			for(int d = 0; d < 4; d++) {
				int newx = currx + dx[d];
				int newy = curry + dy[d];
				if (newx <0 || newx >= N || newy < 0 || newy >=N)
					continue;
				if (map[curry][currx]+1 != map[newy][newx])
					continue;
				
				q.offer(new int[] {newx,newy,dist+1});		
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int y = 0 ; y< N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x<N;x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int y = 0 ; y< N; y++) {
				for(int x = 0; x<N;x++) {
					bfs(x,y);
				}
			}
			System.out.println("#"+ test_case+ " " + roomnumber + " "+ max);
		}
	}
}