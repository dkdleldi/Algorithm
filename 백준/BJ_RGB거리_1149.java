import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_RGB거리_1149 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] memoi = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(i == 0) {
				memoi[0][0] = R;
				memoi[0][1] = G;
				memoi[0][2] = B;
				continue;
			}
			memoi[i][0] = Math.min(R + memoi[i-1][1], R + memoi[i-1][2]);
			memoi[i][1] = Math.min(G + memoi[i-1][0], G + memoi[i-1][2]);
			memoi[i][2] = Math.min(B + memoi[i-1][0], B + memoi[i-1][1]);
		}

		int min = Math.min(memoi[N-1][0], memoi[N-1][1]);
		min = Math.min(min, memoi[N-1][2]);
		System.out.println(min);
	}
}
