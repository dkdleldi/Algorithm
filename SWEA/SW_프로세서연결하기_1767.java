import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_프로세서연결하기_1767 {

	static int T, N, coreNum, min, num;
	static int[][] proc;
	static ArrayList<Core> list;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			proc = new int[N][N];
			list = new ArrayList<>();
			num = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					proc[i][j] = Integer.parseInt(st.nextToken());
					if(proc[i][j] == 1) {
						list.add(new Core(i, j));
						num++;
					}
				}
			}
			min = Integer.MAX_VALUE;
			coreNum = 0;
			connect(proc, 0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	static void connect(int[][] map, int core, int len, int cnt) {
		if(cnt == num) {
			if(core >= coreNum) {
				if(core == coreNum) min = Math.min(len, min);
				else min = len;
				coreNum = core;
			}
			return;
		}
		if(core + (num-cnt) < coreNum) return;
		Core c = list.get(cnt);
		if(c.y == 0 || c.x == 0 || c.y == N-1 || c.x == N-1) {
			connect(map, core+1, len, cnt+1);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = c.y + dy[i];
			int nx = c.x + dx[i];
			int l = 0;
			while(true) {
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) break;
				if(map[ny][nx] != 0) break;
				l++;
				if(ny == 0 || nx == 0 || ny == N-1 || nx == N-1) {
					int[][] p = drawProc(c.y, c.x, ny, nx, map);
					connect(p, core+1, len+l, cnt+1);
				}
				ny += dy[i];
				nx += dx[i];
			}
		}
		connect(map, core, len, cnt+1);
	}
	
	static int[][] drawProc(int y, int x, int ny, int nx, int[][] map) {
		int[][] temp = copy(map);
		if(y == ny) {
			if(x < nx) {
				for (int i = x+1; i <= nx; i++) {
					temp[y][i] = 2;
				}
			}
			else {
				for (int i = nx; i < x; i++) {
					temp[y][i] = 2;
				}
			}
		}
		if(x == nx) {
			if(y < ny) {
				for (int i = y+1; i <= ny; i++) {
					temp[i][x] = 2;
				}
			}
			else {
				for (int i = ny; i < y; i++) {
					temp[i][x] = 2;
				}
			}
		}
		return temp;
	}

	static int[][] copy(int[][] origin) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = origin[i][j];
			}
		}
		return temp;
	}
	
	static class Core {
		int y;
		int x;
		public Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
