package boj3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * R행 C열
 * 빈곳 . 물 * 돌 X 비버굴 D 고슴도치 S
 * 
 * 고슴도치 상하좌우 이동
 * 물 비어있는 칸으로 확장
 * 
 * 
 * 
 * 
 * @author SSAFY
 *
 */
public class boj3055 {
	public static int Map[][],Y,X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		Map = new int [Y][X];
		for(int y = 0; y < Y;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0; x < X; x++) {
				Map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
