import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_적록색약_10026 {

	static int N, num;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					divide(i, j);
					num++;
				}
			}
		}
		System.out.print(num + " ");
		
		visit = new boolean[N][N];
		num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					divide(i, j);
					num++;
				}				
			}
		}
		System.out.print(num);

	}
	static void divide(int y, int x) {
		visit[y][x] = true;
		char c = map[y][x];
		if ( map[y][x] == 'G' ) map[y][x] = 'R';
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if( ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != c ) continue;			
			divide(ny, nx);			
		}
	}
}
