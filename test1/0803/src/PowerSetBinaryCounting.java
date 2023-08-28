
public class PowerSetBinaryCounting {

	static int N = 5;
	static int[] arr= {1,3,5,7,9};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int flag = 0; flag<=Math.pow(2, N)-1;flag++) {
			System.out.printf("%5s\n",Integer.toBinaryString(flag));
		}*/	
		for(int flag = 0; flag<=(1 << N) -1; flag++) {
			System.out.printf("%5s\n",Integer.toBinaryString(flag));
			//0번째 요소가 선택됐는지
			
			for (int i = 0; i < arr.length;i++) {
				if ((flag & 1 << i) > 0) {
					System.out.printf("%d, ", arr[i]);
				}
			}
			System.out.println();
			
		}
		
	}
}
