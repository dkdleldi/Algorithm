package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_최대공약수와최소공배수_2609 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int numMin = Math.min(num1, num2);
		int max = 1;
		int min = 1;
		for (int i = numMin; i > 0; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				max = i;
				break;
			}
		}
		min = max * (num1 / max) * (num2 / max);
		System.out.println(max);
		System.out.println(min);
	}
}
