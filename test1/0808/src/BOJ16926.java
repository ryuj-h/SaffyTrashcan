import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16926 {
	static int N,M,R;
	static int map[][];

	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void print_map() {		
		for(int y = 0; y <N;y++ ) {
			for(int x = 0; x < M;x++) {
				System.out.printf("%d ", map[y][x]);
			}
			System.out.printf("\n");
		}
	}
	
	public static void rotate() {
		int tmpMap[][] = new int[N+1][M+1];

		Scanner sc = new Scanner(System.in);
		int i = 1;

		int currposx = 0;
		int currposy = 0;
		int dir = 0;
		tmpMap[0][0] = map[0][1];
		while(true) {
			System.out.println(currposx + " , "+ currposy);

			for(int y = 0; y <N;y++ ) {
				for(int x = 0; x < M;x++) {
					System.out.printf("%d ", tmpMap[y][x]);
				}
				System.out.printf("\n");
			}
			sc.nextLine();
			
			
			int newposx = currposx + dx[dir];
			int newposy = currposy + dy[dir];
			if (newposx < 0 || newposx >= M ||newposy < 0 || newposy >= N) {
				dir++;
				if (dir > 3)
					dir = 0;
				continue;
			}
			if (tmpMap[newposy][newposx] != 0) {
				dir++;
				if (dir > 3)
					dir = 0;
				continue;
			}
			else {
				tmpMap[newposy][newposx] = map[currposy][currposx];
				currposx = newposx;
				currposy = newposy;
			}
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());	

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int y = 0; y <N;y++ ) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate();
		
		print_map();
		
	}
}
