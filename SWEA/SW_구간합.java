package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_구간합 {

	static int T;
	static long A, B, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			ans = 0;
			long d = 1;
			while(A <= B) {
				while(A % 10 != 0 && A <= B) {
					cal(A, d);
					A++;
				}
				if( A > B || (A == 0 && B == 0)) break;
				while(B % 10 != 9 && A <= B) {
					cal(B, d);
					B--;
				}
				A /= 10;
				B /= 10;
				long l = (B-A+1) * d;
				for (int i = 0; i < 10; i++) {
					ans += l * i;
				}
				d *= 10;	
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void cal(long n, long t) {
		while(n > 0) {
			ans += n % 10 * t;
			n /= 10;
		}
	}
}
