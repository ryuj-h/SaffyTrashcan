package test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기_류진호 {
	static int SwitchNum = 0;
	static int arr[] = new int [101];
	
	void manturn(int index) {
		
	}
	void womanturn(int index) {
		
	}
	
	public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			SwitchNum = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0; i < SwitchNum;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
							
			}
			
			
	}
}
