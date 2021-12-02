import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_쿼드트리_1992 {
	static int N, num;
	static int[][] image;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				image[i][j] = temp[j] - '0';
			}
		}
		if(search(0, 0, N)) {
			sb.append(num);
		}
		else zip(0, 0, N/2);
		System.out.println(sb);		
	}
	static void zip(int y, int x, int n) {
		if(n < 1) return;
		sb.append("(");
		if(!search(y, x, n)) zip(y, x, n/2);
		else sb.append(num);
		if(!search(y, x+n, n)) zip(y, x+n, n/2);
		else sb.append(num);
		if(!search(y+n, x, n)) zip(y+n, x, n/2);
		else sb.append(num);
		if(!search(y+n, x+n, n)) zip(y+n, x+n, n/2);
		else sb.append(num);
		sb.append(")");
	}
	static boolean search(int y, int x, int n) {
		num = image[y][x];
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(num != image[i][j]) return false;
			}
		}
		return true;
	}
}
