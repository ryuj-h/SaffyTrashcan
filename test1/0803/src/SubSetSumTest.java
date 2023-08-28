import java.util.Scanner;

public class SubSetSumTest {
	
	static int N, Target, input[];
	static boolean isSelected[];
	
	private static void generateSubset(int cnt) {
		if (cnt == N) {
			//부분집합의 구성 원소의 합을 구하고 sum과 비교
			int temp = 0;
			for (int i =0; i <N;i++) {
				if (isSelected[i]) {
					temp += input[i];
				}
			}
			if (temp == Target) {
				for(int i = 0; i< N;i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			
			
			
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}	
	
	private static void generateSubset2(int cnt, int sum,int selectedCount) {
		if (cnt == N) {
			//부분집합의 구성 원소의 합을 구하고 sum과 비교

			if (selectedCount > 0 && sum == Target) {
				for(int i = 0; i< N;i++) {
					if (isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			
			
			
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset2(cnt + 1,sum + input[cnt], selectedCount+1);
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum, selectedCount);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Target = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N;i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0);
	}
}
