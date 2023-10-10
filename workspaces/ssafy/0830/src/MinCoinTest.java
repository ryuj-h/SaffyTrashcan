import java.util.Scanner;

public class MinCoinTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		int D[] = new int[money+1];//금액 n에 대한 최소 동전 수
		D[0] = 0;//점화식으로 채워질 수 없는 동적테이블의 값 초기화.
		
		for(int i = 1; i <= money; i++) {
			//1원 시도
			D[i] = D[i - 1 ] + 1;
			
			//4원 시도
			if (i >= 4) 
				D[i] = Math.min(D[i - 4]+1, D[i]);
			
			//6원 시도
			if (i >= 6) 
				D[i] = Math.min(D[i - 6]+1, D[i]);
		}
		
		System.out.println(D[money]);
		
	}
}
