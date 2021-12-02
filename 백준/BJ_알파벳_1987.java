import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_알파벳_1987 {

	static int R, C, ans, max, index;
	static char[][] board;
	static boolean[][] visit;
	static ArrayList<Character> check = new ArrayList<>();
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		check.add(board[0][0]);
		ans = 1;
		max = 1;
		visit[0][0] = true;
		move(0, 0);
		System.out.println(ans);
	}
	static void move(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			boolean isPossible = true;
			if(ny < 0 || ny >= R || nx < 0 || nx >= C || visit[ny][nx]) continue;
			for (int j = 0; j < check.size(); j++) {
				if(board[ny][nx] == check.get(j)) {
					isPossible = false;
					break;
				}
			}
			if(!isPossible) continue;
			max++;
			index++;
			check.add(board[ny][nx]);
			visit[ny][nx] = true;
			move(ny, nx);
			visit[ny][nx] = false;
			check.remove(index--);
			max--;
		}
		ans = Math.max(max, ans);
	}
}
