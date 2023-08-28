package test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class tttttt {
	static int N;
	static int arr[];
	static int picked[];
	static boolean visited[];
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	public static void comb(int cnt) {
		if(cnt == M) {
			count++;
			for(int i =0; i < M;i++) {
				sb.append(picked[i] + " ");		
			}
			sb.append("\n");
		}
		for(int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			picked[cnt] = arr[i];
			comb(cnt + 1);
			visited[i] = false;
		}
	}
	
	
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(br.readLine());
				//sc.nextInt();
		arr = new int [N];
		visited = new boolean[N];
		picked = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for( int i = 0; i < N; i++) {
			arr[i] =Integer.parseInt(st.nextToken()); 
		}
		M = Integer.parseInt(br.readLine());
				//sc.nextInt();
		
		
		comb(0);
		sb.append(count);
		System.out.println(sb);
	}
}
