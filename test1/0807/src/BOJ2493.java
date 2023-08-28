import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ2493 {
	static int N;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static int Find(int index) {
		int find = arr[index];
		int index2 = index;
		int result = -1;
		while(true) {
			index2 = index2 - 1;
			if (index2 < 0 || index2 >= N)
				break;
			if(arr[index2] > find) {
				result = index2;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		arr = new int[N +1];
		for(int i = 0 ;i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int res = Find(i);
			if (res != -1) {
				sb.append((res + 1) + " ");
			}
			else
				sb.append(0 + " ");
		}
		System.out.println(sb);
		
		
	}
}
