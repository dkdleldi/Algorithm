package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_별삼각형1_1523 {

	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(n > 100) System.out.println("INPUT ERROR!");
		else if(m == 1) type1(n);
		else if(m == 2) type2(n);
		else if(m == 3) type3(n);
		else System.out.println("INPUT ERROR!");
	}
	static void type1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void type2(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void type3(int n) {
		int blank = n-1;
		for (int i = 1; i <= 2*n - 1; i = i+2) {
			for (int j = blank; j > 0; j--) {
				System.out.print(" ");
			}
			blank--;
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
