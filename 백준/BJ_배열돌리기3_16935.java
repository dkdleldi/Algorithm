import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기3_16935 {
	static int N, M, R;
	static int[][] array;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				first();
				break;
			case 2:
				second();
				break;
			case 3:
				third();
				break;
			case 4:
				fourth();
				break;
			case 5:
				fifth();
				break;
			case 6:
				sixth();
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void first() {
		int sy = 0;
		int ey = N-1;
		int[] temp = new int[M];
		while(true) {
			if(sy >= ey) break;
			for (int i = 0; i < M; i++) {
				temp[i] = array[sy][i];
				array[sy][i] = array[ey][i];
				array[ey][i] = temp[i];
			}
			sy++;
			ey--;
		}
	}
	static void second() {
		int sx = 0;
		int ex = M-1;
		int[] temp = new int[N];
		while(true) {
			if(sx >= ex) break;
			for (int i = 0; i < N; i++) {
				temp[i] = array[i][sx];
				array[i][sx] = array[i][ex];
				array[i][ex] = temp[i];
			}
			sx++;
			ex--;
		}
	}
	static void third() {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				rotate[i][j] = array[N-1-j][i];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = rotate[i][j];
			}
		}
	}
	static void fourth() {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				rotate[i][j] = array[j][M-1-i];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = rotate[i][j];
			}
		}
	}
	static void fifth() {
		int[][] temp = new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j] = array[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				array[i][j] = array[N/2+i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				array[i][j] = array[i][M/2+j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				array[i][j] = array[i-N/2][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				array[i][j] = temp[i][j-M/2];
			}
		}
	}
	static void sixth() {
		int[][] temp = new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j] = array[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				array[i][j-M/2] = array[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				array[i-N/2][j] = array[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				array[i][M/2+j] = array[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				array[i][j] = temp[i-N/2][j];
			}
		}		
	}
}
