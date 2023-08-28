import java.util.Arrays;

public class Test {
	static int[] arr= {6,1,3,7,9,2};
	public static void main(String[] args) {
	
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np(arr));
	}
	
	/**
	 * 해당 arr로 만들 수 있ㅆ는 다음으로 큰 숫자 만들어줌
	 * @param arr
	 * @return true 경우 다음 순열 만들기 성공, false면 더 이상 만들 수 있는 큰 숫자 없음
	 */
	public static boolean np(int[] arr) {
		int N = arr.length;
	

		//step .01 뒤에서 부터 연속하는 두 자리수(i-1, i)를
		
		//오른쪽(i) 이 큰 경우 탐색
		int i = N-1;
		
		while(i > 0 && arr[i-1]>= arr[i]) {
			i--;
		}
		if( i == 0) return false;
		
		//1 2 7 9 6 
		//arr[i-1] = 7 arr[i] = 9
		//j 탐색 7보다 큰 숫자의 위치
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) j--;
		
		//arr[j] = 9
		
		swap(arr,i-1,j);
		
		//arr[i] 요소부터 끝까지를 오름차순 정렬
		int k= N-1;
		while(i < k)swap(arr,i++,k--);
		return true;
	}
	private static void swap(int[] arr2, int i, int j) {
		int temp = arr[i];

		arr[i]= arr[j];
		arr[j] = temp;
	}
}
