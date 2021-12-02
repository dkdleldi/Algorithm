package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_이진수_3460 {

	static int T, n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			ArrayList<Integer> num = new ArrayList<>();
			while(true) {
				if(n == 0) break;
				num.add(n % 2);
				n = n / 2;
			}
			for (int i = 0; i < num.size(); i++) {
				if(num.get(i) == 1) System.out.print(i + " ");
			}
		}
	}
}
