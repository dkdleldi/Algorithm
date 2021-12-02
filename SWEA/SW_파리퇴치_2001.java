import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_파리퇴치_2001 {
	static int T, N, M, max;
	static int[][] fly;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("SW_2001_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = Integer.MIN_VALUE;
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0;
					for (int dy = i; dy < i+M; dy++) {
						for (int dx = j; dx < j+M; dx++) {
							sum += fly[dy][dx];
						}		
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + t + " " + max);
		}

	}

}
