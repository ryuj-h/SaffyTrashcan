package swea1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1249 {
	
	public static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[1001];
		for(int tc = 1; tc < 11;tc++) {
			
			int N;
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] =  Integer.parseInt(st.nextToken());
			}
			int Solution = 0;
			for (int j = 2; j < N - 2; j++){//맨 왼쪽 두칸과 맨 오른쪽 두칸에는 건물이 지어지지 않는다.
				for (int k = arr[j]; k >= 0; k--){

					int prev2 = arr[j - 2];
					int prev1 = arr[j - 1];
					int curr = k;
					int next1 = arr[j + 1];
					int next2 = arr[j + 2];

					if (prev2 < curr &&
						prev1 < curr &&
						next1 < curr &&
						next2 < curr) {
						Solution++;
					}
					else
						break;
				}
			}
			System.out.println("#" + tc +" " + Solution);
		}
	}
}
