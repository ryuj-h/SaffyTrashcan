package boj2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2239 {
	
	static char Map[][];
	
	boolean checkdone() {
		//3x3 체크
		for(int yy= 0; yy < 3; yy++) {
			for(int xx = 0; xx < 3; xx++) {
				
				boolean visit3x3[] = new boolean[9];
				for(int y= 0; y < 3; y++) {
					for(int x= 0; x< 3; x++) {
						int rx = 3* xx + x;
						int ry = 3* yy + y;
						
						if(visit3x3[Map[ry][rx]])
							return false;
						visit3x3[Map[ry][rx]] = true;
					}
				}	 
			}
		}
		
		
	}
	
	public void dfs() {
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map = new char[9][9];
		
		for(int i= 0; i < 9;i++) {
			Map[i] = br.readLine().toCharArray();
		}
		
		
	}
}
