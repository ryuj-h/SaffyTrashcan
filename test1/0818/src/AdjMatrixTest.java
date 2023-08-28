import java.util.*;

public class AdjMatrixTest {
	static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		//bfs(adjMatrix);
		dfs(adjMatrx,new boolean[V],0);
	}
	private static void bfs0(int[][] adjMatrix) {
		int size = adjMatrix.length;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[size];
		// 탐색 시작점 정점 0으로 하자
		queue.offer(0);
		visited[0] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			
			//현 정점의 인접정점을 체크하며 대기열에 넣기
			for(int i = 0; i < size; i++) {
				if (adjMatrix[current][i] == 1&& !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
	private static void bfs(int[][] adjMatrix) {
		int size = adjMatrix.length;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[size];
		// 탐색 시작점 정점 0으로 하자
		queue.offer(0);
		visited[0] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			
			//현 정점의 인접정점을 체크하며 대기열에 넣기
			for(int i = 0; i < size; i++) {
				if (adjMatrix[current][i] == 1&& !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	private static void dfs(int [][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println((char)(current + 65));

		for(int i = 0, size = adjMatrix.length; i < size; i++) {
			if (adjMatrix[current][i] == 1&& !visited[i]) {
				dfs(adjMatrix,visited,i);
				
			}
		}
	}
	private static void dfs2(int [][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println((char)(current + 65));

		for(Node temp = adjList[current]; temp != null; temp = temp.next) {
			if (adjMatrix[current][i] == 1&& !visited[i]) {
				dfs(adjMatrix,visited,i);
				
			}
		}
	}
}
