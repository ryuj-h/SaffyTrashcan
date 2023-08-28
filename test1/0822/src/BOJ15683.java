import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV{
	public int x,y,type,dir;
}

public class BOJ15683 {
	static int N, M;
	static int map[][];
	static int savemap[][];
	static CCTV cctvs[] = new CCTV[8];
	static int cctvnum = 0;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int Solution = Integer.MAX_VALUE;
	
	/**
	 * cctv가 바라볼 수 있는 곳을 맵에서 지우는 함수
	 * @param cctv
	 */
	public static void EraseMarkedPart(CCTV cctv) {
		ArrayList <Integer> dirs = new ArrayList<>();
		
		switch(cctv.type) {//가독성을 위한 switch
		case 1:
			dirs.add(cctv.dir);
			break;
		case 2:
			dirs.add(cctv.dir);
			dirs.add((cctv.dir+ 2) % 4);// dir은 4방향 뿐이므로 2를 더해서 4 나머지를 해준다면 반대 방향이 나옴 * dx dy 를 좌상우하로 구성 하였음 *
			break;
		case 3:
			dirs.add(cctv.dir);
			dirs.add((cctv.dir + 1) % 4);
			break;
		case 4:
			dirs.add(cctv.dir);
			dirs.add((cctv.dir + 1) % 4);
			dirs.add((cctv.dir + 2) % 4);
			break;
		case 5:
			dirs.add(cctv.dir);
			dirs.add((cctv.dir + 1) % 4);
			dirs.add((cctv.dir + 2) % 4);
			dirs.add((cctv.dir + 3) % 4);
			break;
		}
		for (int dir : dirs) {
			int currx = cctv.x;
			int curry = cctv.y;
			
			while(true) {
				int nextx = currx + dx[dir];
				int nexty = curry + dy[dir];
				
				//벽을 만나거나 맵을 벗어날때까지 반복
				if (nextx <0 || nextx >= M || nexty <0 || nexty >= N)
					break;
				if (map[nexty][nextx] == 6)
					break;
				
				if (map[nexty][nextx] < 1)
					map[nexty][nextx] = 9;
				currx = nextx;
				curry = nexty;
			}
			
		}
	}
	
	public static void dfs(int index) {
		if(index == cctvnum) {
			//맵 백업
			for(int y= 0; y< N;y++) {
				for(int x = 0; x< M; x++) {
					savemap[y][x] = map[y][x];
				}
			}
			
			//CCTV가 보는 방향 전부 지워주기
			for(int i =0 ; i < cctvnum;i++) 
				EraseMarkedPart(cctvs[i]);
			
			//마크되지 않은 부분 cnt++
			int unmarkednum = 0;
			for(int y= 0;  y< N; y++) {
				for(int x = 0; x < M ;x++) {
					if (map[y][x] == 0) {
						unmarkednum++;
					}
				}
			}

			//최소 값 구하기
			Solution = Math.min(unmarkednum, Solution);
			
			//백업본으로 원본 덮어씌우기
			for(int y= 0; y< N;y++) {
				for(int x = 0; x< M; x++) {
					map[y][x] =savemap[y][x];
				}
			}
			return;
		}
		
		//cctv를 돌려가면서 dfs탐색!
		for(int d =0; d<4;d++) {
			cctvs[index].dir = d;
			dfs(index+1);
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		savemap = new int[N][M];
		
		for(int y= 0;  y< N; y++) {
			st = new StringTokenizer (br.readLine());
			for(int x = 0; x < M ;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] != 0 &&map[y][x] != 6 ) {
					cctvs[cctvnum] = new CCTV();
					cctvs[cctvnum].x = x;
					cctvs[cctvnum].y = y;
					cctvs[cctvnum].type = map[y][x];
					
					cctvnum++;
				}
			}
		}
		
		dfs(0);//dfs를 사용하여 조합
		System.out.println(Solution);
	}
}
