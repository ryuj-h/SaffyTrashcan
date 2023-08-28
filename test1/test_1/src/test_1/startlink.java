package test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class startlink {
	public static int N;
	public static int arr[][];
	
	public static void dfs(int i) {
		
	}
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int y = 0; y < N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int x =0;x <N;x++ ) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}			
		}
		
		
		
		
		/*for(int y = 0; y < N;y++) {
			for (int x =0;x <N;x++ ) {
				System.out.printf("%d ",arr[y][x]);
			}			
			System.out.println();
		}*/
	}	
}
