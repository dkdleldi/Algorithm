package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_약수와배수_1071 {

	static int n, m;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		int divSum = 0;
		int mulSum = 0;
		for (int i = 0; i < n; i++) {
			if(m % num[i] == 0) divSum += num[i];
			if(num[i] % m == 0) mulSum += num[i];
		}
		System.out.println(divSum);
		System.out.println(mulSum);
	}
}
