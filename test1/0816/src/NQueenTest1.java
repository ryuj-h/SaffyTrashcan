import java.util.Scanner;

//같은 행에는 퀸을 놓지 않는 버전
//놓아진 퀸의 열번호를 기록하는 버전
public class NQueenTest1 {
	static int N,col[],ans;
	public static void main(String args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];//1열부터 사용
		ans = 0;
	
		setQueen(1);
		System.out.println(ans);
	}
	//해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {

		//가지치기 : 직전까지 놓아진 상태로 
		if (!isAvailable(row - 1)) return;
		//기저조건
		if (row > N) {
			ans++;
			return;
		}
		//유도파트
		for (int c = 1; c <= N; c++) {
			col[row] = c;
			setQueen(row + 1);
		}
	}
	
	private static boolean isAvailable(int row) {
		for( int i = 1; i < row;i++) {
			if (col[i] == col[row] || row - i == Math.abs(col[row]- col[i]))
				return false;
		}
		return true;
	}
}
