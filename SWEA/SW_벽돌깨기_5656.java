import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_벽돌깨기_5656 {

	static int T, N, W, H, min;
	static int[][] brick;
	static int[][] backup;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			brick = new int[H][W];
			backup = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					backup[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			tgt = new int[N];
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + t + " " + min);
		}
	}

	static void perm(int tgtIdx) {
		if(min == 0) return;
		if(tgtIdx == N) {
			copy();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < H; j++) {
					if(brick[j][tgt[i]] != 0) {
						remove(j, tgt[i]);
						arrange();
						break;
					}
				}
			}
			int remain = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(brick[i][j] > 0) remain++;
				}
			}
			if(remain < min) min = remain;
			return;
		}
		for (int i = 0; i < W; i++) {
			tgt[tgtIdx] = i;
			perm(tgtIdx+1);
		}
	}
	
	static void remove(int y, int x) {
		int size = brick[y][x]-1;
		brick[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y;
			int nx = x;
			for (int j = 0; j < size; j++) {
				ny += dy[i];
				nx += dx[i];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || brick[ny][nx] == 0) continue;
				if(brick[ny][nx] > 1) remove(ny, nx);
				else if(brick[ny][nx] == 1) brick[ny][nx] = 0;
			}
		}
	}
	
	static void arrange() {
		for (int i = 0; i < W; i++) {
			for (int j = H-1; j > 0; j--) {
				if(brick[j][i] == 0) {
					int idx = j-1;
					while(idx >= 0) {
						if(brick[idx][i] != 0) {
							brick[j][i] = brick[idx][i];
							brick[idx][i] = 0;
							break;
						}
						idx--;
					}
				}
			}
		}
	}
	
	static void copy() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				brick[i][j] = backup[i][j];
			}
		}
	}
}