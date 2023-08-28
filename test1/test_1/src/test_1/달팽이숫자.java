package test_1;

import java.util.Scanner;

public class 달팽이숫자 {
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	public static void turn(int posx, int posy) {
		
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			
			int posx= 0,posy = 0;
			
			int currturn = 1;
			int currd = 0;
			while(true) {
				arr[posy][posx] = currturn;
				if (currturn == N*N)
					break;
				
				while(true) {
					int nextposx = posx + dx[currd];
					int nextposy = posy + dy[currd];
					if (nextposx<0 || nextposx>=N || nextposy <0 ||nextposy>=N) {
						currd++;
						if (currd ==4)
							currd = 0;
					}
					else {
						if (arr[nextposy][nextposx] == 0) {
							posx = nextposx;
							posy = nextposy;
							break;
						}
						else {
							currd++;
							if (currd ==4)
								currd = 0;
						}
					}
				}
				currturn++;
			}

			System.out.printf("#%d\n",test_case);
			for(int i =0; i< N; i++) {
				for(int j=0; j< N;j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
