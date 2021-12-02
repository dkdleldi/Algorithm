package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_활주로건설 {

	static int T, N, X, ans;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			possible();
			System.out.println("#" + t + " " + ans);
		}
	}

	static void possible() {
		for (int i = 0; i < N; i++) {
			int floor = map[i][0];
			int cnt = 1;
			boolean pos = true;
			for (int j = 1; j < N; j++) {
				if(map[i][j] == floor) cnt++;
				else if(map[i][j] == floor+1) {
					if(cnt < X) {
						pos = false;
						break;
					}
					floor = map[i][j];
					cnt = 1;
				}
				else if(map[i][j] == floor-1) {
					if(N-j >= X) {
						floor = map[i][j];
						cnt = 1;
						for (int k = 1; k < X; k++) {
							if(map[i][j+k] == floor) cnt++;
						}
						if(cnt != X) {
							pos = false; 
							break;
						}
						j += X-1;
						cnt = 0;
						floor = map[i][j];
					} else {
						pos = false;
						break;
					}
				}
				else {
					pos = false;
					break;
				}
			}
			if(pos) ans++;
		}
		for (int i = 0; i < N; i++) {
			int floor = map[0][i];
			int cnt = 1;
			boolean pos = true;
			for (int j = 1; j < N; j++) {
				if(map[j][i] == floor) cnt++;
				else if(map[j][i] == floor+1) {
					if(cnt < X) {
						pos = false;
						break;
					}
					floor = map[j][i];
					cnt = 1;
				}
				else if(map[j][i] == floor-1) {
					if(N-j >= X) {
						floor = map[j][i];
						cnt = 1;
						for (int k = 1; k < X; k++) {
							if(map[j+k][i] == floor) cnt++;
						}
						if(cnt != X) {
							pos = false; 
							break;
						}
						j += X-1;
						cnt = 0;
						floor = map[j][i];
					} else {
						pos = false;
						break;
					}
				}
				else {
					pos = false;
					break;
				}
			}
			if(pos) ans++;
		}
	}
}
