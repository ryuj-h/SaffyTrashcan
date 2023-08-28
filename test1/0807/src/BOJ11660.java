import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	static int N;
	static int M;
	static int arr[];
	static int sumarr[];

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr =new int[N*N+1];
		sumarr = new int[N*N+1];
		for(int y = 0; y <N; y++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int x = 0; x < N; x++) {
				int newindex = N * y + x + 1;
				
				arr[newindex] = Integer.parseInt(st.nextToken());
				sumarr[newindex] = sumarr[newindex - 1] + arr[newindex];
			}
		}

		/*for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumarr[i] = sumarr[i-1] + arr[i];
		}*/


		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int vi = N*(y1-1) + x1;
			int vj = N*(y2-1) + x2;
			sb.append((sumarr[vj] - sumarr[vi - 1]) + "\n");
			//System.out.println(sumarr[vj] - sumarr[vi - 1]);
		}
		

		System.out.println(sb);
	}
}
