import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제 해결 방식 : 완전 탐색
 * 가로, 세로, 3 x 3 매트릭스 체크
 * 
 * @author SSAFY
 *
 */
public class swea1974 {
	static int T;
	static int Map[][];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		Map = new int[9][9];
		
		StringTokenizer st;
		for(int tc = 1 ; tc <=T;tc++) {
			for(int y =0; y< 9; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0; x < 9; x++) {
					Map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			//가로 체크
			boolean xdone = false;
			loops:
			for(int y= 0; y< 9;y++) {
				boolean[] checkarr = new boolean[10];
				
				for(int x= 0; x< 9; x++) {
					checkarr[Map[y][x]-1] = true;
				}
				xdone = true;
				for(int x= 0; x< 9; x++) {
					if (!checkarr[x]) {
						xdone = false;
						break loops;
					}
				}
			}


			//세로 체크
			boolean ydone = false;
			if(xdone) {
				loops:
				for(int x= 0; x< 9;x++) {
					boolean[] checkarr = new boolean[10];
					for(int y= 0; y< 9; y++) 
						checkarr[Map[y][x]-1] = true;
					ydone = true;
					for(int y= 0; y< 9; y++) {
						if (!checkarr[y]) {
							ydone = false;
							break loops;
						}
					}
				}
			}
			
			//3x3 행렬 체크
			boolean done33 = false;
			if(xdone && ydone) {
				loops:
				for(int y = 0; y < 3; y++) {
					for(int x = 0; x < 3; x++) {
						done33 = true;
						boolean[] checkarr = new boolean[10];
						for(int yy= 0; yy < 3; yy++) {
							for(int xx = 0;xx < 3; xx++) {
								checkarr[Map[3*y + yy][3*x + xx]-1] = true;
							}
						}
						for(int i= 0; i< 9; i++) {
							if (!checkarr[i]) {
								done33 = false;
								break loops;
							}
						}
					}
				}
			}
			
			int solution = -1;
			if (done33) {
				solution = 1;
			}
			else {
				solution = 0;
			}
			System.out.println("#" + tc + " "+ solution );
		}
	}
}
