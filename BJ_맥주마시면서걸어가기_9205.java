import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_맥주마시면서걸어가기_9205 {

	static int T, n;
	static int[][] map;
	static int[][] loc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+2][n+2];
			loc = new int[n+2][2];
			
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					loc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if(i == j) continue;
					int m = Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1]);
					if(m <= 1000) map[i][j] = m;
					else map[i][j] = 999999;
				}
			}
			
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					if(i == k) continue;
					for (int j = 0; j < n+2; j++) {
						if(i == j || j == k) continue;
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			if(map[0][n+1] != 999999) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}