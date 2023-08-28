import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTPrimTest {
	static int V, adjMatrix[][];
	static boolean visited[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(in.readLine());
		adjMatrix = new int[V][V];
		visited = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[V];
		int [] minEdge = new int[V];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;//임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅
		
		int result = 0;
		int min = 0, minVertex= 0;
		for(int c =0; c < V;c++) {
			min =  Integer.MAX_VALUE;
			minVertex = -1;
			//step1 : 미방문(비트리) 정점 중 최소간선비용의 정점을 선택
			for(int i =0; i< V; i++) {
				if (!visited[i] && min> minEdge[i]) {
					minVertex = i;
					min = minEdge[i];
				}
			}
			//step 2 : 방문(트리) 정점에 추가
			visited[minVertex] = true;
			result +=min;
			
			//step 3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려
			for (int i =0; i < V ;i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}
}
