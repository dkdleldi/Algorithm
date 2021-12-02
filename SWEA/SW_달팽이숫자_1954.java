import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_달팽이숫자_1954 {
	static int N;
	static int[][] snail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			
			int num = 1;
			int y = 0;
			int x = 0;
			int dir = 0;
			snail[y][x] = num;
			while(true) {
				for (int i = 0; i < N; i++) {
					if(dir == 0 && x+1 < N && snail[y][x+1] == 0) x = x+1;
					else if(dir == 2 && x-1 >= 0 && snail[y][x-1] == 0) x = x-1;
					else if(dir == 1 && y+1 < N && snail[y+1][x] == 0) y = y+1;
					else if(dir == 3 && y-1 >= 0 && snail[y-1][x] == 0) y = y-1;
					else break;
					snail[y][x] = ++num;
				}
				dir++;
				if(dir >= 4) dir = 0;
				if(num == N*N) break;
			}
			
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
