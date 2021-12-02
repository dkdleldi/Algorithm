package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사칙연산유효성검사 {
	static int N, correct;
	static char[] node;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1233_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				node[i] = st.nextToken().charAt(0);
			}
			correct = 1;
			dfs(1);
			System.out.println("#" + t + " " + correct);
		}

	}
	static void dfs(int index) {
		// 기저 조건
		if(index > N) return;
		
		if(node[index] > '0') {
			if(index*2 > N) return;
			else {
				correct = 0;
				return;
			}
		}
		else {
			dfs(index*2);
			dfs(index*2+1);
		}
	}
}
