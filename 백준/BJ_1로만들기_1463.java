package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1로만들기_1463 {

	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cnt = Integer.MAX_VALUE;
		cal(0, N);
		System.out.println(cnt);
	}
	static void cal(int count, int num) {
		if(count > cnt) return;
		if(num == 1) {
			cnt = count;
			return;
		}				
		if(num % 3 == 0) {
			cal(count+1, num / 3);
		}
		if(num % 2 == 0) {
			cal(count+1, num / 2);
		}
		if(num > 1) {
			cal(count+1, num-1);
		}		
	}
}
