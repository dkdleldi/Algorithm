package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사람네트워크2 {
	
	static int T, N;
	static int[][] node;
	static int[] cc;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1263_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			node = new int[N][N];
			cc = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					node[i][j] = Integer.parseInt(st.nextToken());
					if(node[i][j] == 0 && i != j) node[i][j] = 5000;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(i == j || i == k || j == k) continue;
						node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cc[i] += node[i][j];
				}
			}
			
			int m = 5000;
			for (int i = 0; i < N; i++) {
				if(m > cc[i]) m = cc[i];
			}
			
			System.out.println("#" + t + " " + m);
		}	
	}
}
