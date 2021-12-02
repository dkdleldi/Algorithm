package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_치즈 {

	static int Y, X, left;
	static int[][] cheese;
	static boolean[][] visitAir;
	static boolean[][] visitCheese;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<int[]> queueAir;
	static Queue<int[]> queueCheese;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		cheese = new int[Y][X];
		visitAir = new boolean[Y][X];
		visitCheese = new boolean[Y][X];
		left = 0;
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) left++;
			}
		}
		queueAir = new LinkedList<>();
		queueCheese = new LinkedList<>();
		queueAir.offer(new int[] {0, 0});
		int hour = 0;
		int ans = left;
		while(true) {	
			bfsair();
			bfscheese();
			hour++;
			if(left == 0) break;
			ans = left;
		}
		System.out.println(hour);
		System.out.println(ans);
	}
	
	static void bfsair() {
		while(!queueAir.isEmpty()) {
			int[] a = queueAir.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = a[0] + dy[i];
				int nx = a[1] + dx[i];
				if(ny < 0 || nx < 0 || ny >= Y || nx >= X || visitAir[ny][nx] || visitCheese[ny][nx]) continue;
				if(cheese[ny][nx] == 0) {
					queueAir.offer(new int[] {ny, nx});
					visitAir[ny][nx] = true;
				}
				
				else if(cheese[ny][nx] == 1) {
					queueCheese.offer(new int[] {ny, nx});
					visitCheese[ny][nx] = true;
				}
			}
		}		
	}
	
	static void bfscheese() {
		while(!queueCheese.isEmpty()) {
			int[] c = queueCheese.poll();
			cheese[c[0]][c[1]] = 0;
			queueAir.offer(c);
			visitAir[c[0]][c[1]] = true;
			left--;
		}	
	}
}
