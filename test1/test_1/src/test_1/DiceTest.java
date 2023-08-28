package test_1;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int N, numbers[];
	static boolean isSelected[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력으로 주사위 던지는 횟수, 주사위 던지기 모드(1,2,3,4)
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 int M = sc.nextInt();
		 numbers = new int[N];
		 switch(M) {
		 case 1:
			 dice1(0);
			 break;
		 case 2:
			 isSelected = new boolean[7];
			 dice2(0);
			 break;
		 case 3:
			 dice3(0,1);
			 break;
		 case 4:
			 dice4(0,1);
			 break;
		 }
	}
	//중복된 주사위 눈 가능
	private static void dice1(int cnt) {//cnt + 1번째 주사위 한번 던지기 cnt : 기존까지 던져진 주사위 횟수
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//한번 던질때 가능한 상황에 대한 시도(1,2,3,4,5,6 주사위 눈이 가능)
		for( int i = 1; i <= 6;i++) {
			// 기존 주사위의 눈고 중복되는지 체크
			numbers[cnt]= i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) {//cnt + 1번째 주사위 한번 던지기 cnt : 기존까지 던져진 주사위 횟수
		
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//한번 던질때 가능한 상황에 대한 시도(1,2,3,4,5,6 주사위 눈이 가능)
		for( int i = 1; i <= 6;i++) {
			// 기존 주사위의 눈고 중복되는지 체크
			if (isSelected[i])continue;
			numbers[cnt]= i;
			isSelected[i] = true;
			dice2(cnt+1);
			//현 주사위의 눈을 다른 선택지로 시도하기 위한 준비
			isSelected[i] = false;
		}
	}
	
	
	/**
	 * 중복조합
	 * @param cnt
	 * @param start 시작 주사위 눈의 수
	 */
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <=6 ; i++ ) {
			numbers[cnt] = i;
			dice3(cnt+1,i+1);
		}
	}
	
	/**
	 * 조합
	 * @param cnt
	 * @param start 시작 주사위 눈의 수
	 */
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
	
		for(int i = start; i <=6 ; i++ ) {
			numbers[cnt] = i;
			dice4(cnt+1,i);
		}
	}
}
