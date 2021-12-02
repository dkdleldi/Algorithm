package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_날짜계산기_1948 {

	static int T;
	static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int firstMonth = Integer.parseInt(st.nextToken());
			int firstDay = Integer.parseInt(st.nextToken());
			int secondMonth = Integer.parseInt(st.nextToken());
			int secondDay = Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int i = firstMonth; i <= secondMonth; i++) {
				if(i == firstMonth) ans += month[i] - firstDay;
				else if(i == secondMonth) ans += secondDay;
				else ans += month[i];
			}
			System.out.println("#" + t + " " + (ans+1));
		}

	}

}
