package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_빗물_14719 {

	static int H, W;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		boolean[][] block = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				block[H-1-j][i] = true;
			}
		}
		int rain = 0;
		for (int y = 0; y < H; y++) {
			int start = 0;
			int end = 0;
			boolean b = false;
			for (int x = 0; x < W; x++) {
				if(block[y][x] && x+1 < W && !block[y][x+1] && !b) {
					start = x;
					b = true;
				}
				else if(block[y][x] && b) {
					end = x;
					rain += end - start - 1;
					b = false;
					x--;
				}
			}
		}
		System.out.println(rain);
	}
}
