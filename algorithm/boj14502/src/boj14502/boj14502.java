package boj14502;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * dfs 로 조합, 3개의 벽 고른 뒤
 * 
 * bfs로 바이러스 진행하여 안전크기 최대 값 확인
 * 
 * 
 * @author SSAFY
 *
 */

class Point{
	public int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj14502 {
	
	static int N,M;//N y축 M x축
	static int Map[][];
	static int Mapsave[][];
	static boolean Visited[][];
	static boolean Visiteddfs[][];
	static int Solution = Integer.MIN_VALUE;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void savemap() {
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				Mapsave[y][x] = Map[y][x];
			}
		}		
	}
	public static void returnmap() {
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				Map[y][x] = Mapsave[y][x];
			}
		}
	}
	public static int GetSafeZoneNum() {
		int result = 0;
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				if (Map[y][x] == 0) {
					result++;
				}
			}
		}
		return result;
	}
	public static void resetVisited() {
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				Visited[y][x] = false;
			}
		}	
	}
	public static void showMap() {
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				System.out.printf("%d ", Map[y][x]);
			}
			System.out.println();
		}	

		System.out.println();
	}
	
	public static void checkWhitBfs() {
		Queue<Point> q =  new LinkedList<Point>();
		for(int y = 0; y < N; y++) {
			for(int x = 0; x< M; x++) {
				
				if (Map[y][x] == 2) {
					q.add(new Point(x,y));
					Visited[y][x] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point currp = q.poll();
			int currx = currp.x;
			int curry = currp.y;
			
			
			for(int d = 0; d < 4; d++) {
				int nextx = currx + dx[d];
				int nexty = curry + dy[d];
				
				if (nextx < 0 || nextx >=M|| nexty<0||nexty>=N)
					continue;
				if (Map[nexty][nextx] != 0)
					continue;
				if (Visited[nexty][nextx])
					continue;
			
				
				Visited[nexty][nextx] = true;
				Map[nexty][nextx] = 2;
				q.add(new Point(nextx,nexty));
			}
		}
	}
	
	public static void dfs(int x, int y, int depth) {
	    if (depth == 3) {
	        savemap();
	        resetVisited();
	        checkWhitBfs();
	        Solution = Math.max(Solution, GetSafeZoneNum());
	        returnmap();
	        return;
	    }

	    for (int yy = 0; yy < N; yy++) {
	        for (int xx = 0; xx < M; xx++) {
	            int temp = Map[yy][xx];

	            if (temp != 0 || Visiteddfs[yy][xx])
	                continue;

	            Visiteddfs[yy][xx] = true;
	            Map[yy][xx] = 1;
	            dfs(xx + 1, yy, depth + 1);
	            Map[yy][xx] = temp;
	            Visiteddfs[yy][xx] = false;
	        }
	    }
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Visited = new boolean[N][M];
		Visiteddfs = new boolean[N][M];
		Map = new int[N][M];
		Mapsave = new int[N][M];
		
		for(int y= 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x =0; x < M; x++) {
				Map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		

		dfs(0,0,0);
		System.out.println(Solution);
	
	}
}
