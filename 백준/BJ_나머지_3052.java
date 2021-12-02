package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_나머지_3052 {

	static boolean[] remainder;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		remainder = new boolean[42];
		int count = 0;
		for (int i = 1; i <= 10; i++) {
			int num = Integer.parseInt(br.readLine());
			remainder[num%42] = true;
		}
		for (int i = 0; i < 42; i++) {
			if(remainder[i]) count++;
		}
		System.out.println(count);
	}

}
