import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_색종이_2563 {
	static int N, square, height, width;
	static boolean[][] paper = new boolean[101][101];
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			draw(width, height);
		}
		
		int num = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(paper[i][j] == true) num++;
			}
		}
		
		System.out.println(num);

	}
	
	static void draw(int width, int height) {
		for (int y = height; y < height+10; y++) {
			for (int x = width; x < width+10; x++) {
				paper[y][x] = true;
			}
		}
	}

}
