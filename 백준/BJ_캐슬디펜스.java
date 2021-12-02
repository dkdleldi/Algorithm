package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_캐슬디펜스 {
	static int N, M, D, max;
	static int[][] map;
	static int[] archor = new int[3];
	static ArrayList<Enemy> enemy = new ArrayList<>();
	static PriorityQueue<Enemy> kill= new PriorityQueue<>();
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					enemy.add(new Enemy(i, j));
				}
				map[i][j] = num;
			}
		}
		max = Integer.MIN_VALUE;
		comb(0, 0);
		System.out.println(max);
	}
 	static void comb(int srcIdx, int tgtIdx) {
 		if(tgtIdx == 3) {
 			fight();
 			return;
 		}
 		if(srcIdx == M) return;
 		
 		archor[tgtIdx] = srcIdx;
 		comb(srcIdx+1, tgtIdx+1);
 		comb(srcIdx+1, tgtIdx);
 	}
 	
 	static void fight() {
 		int killed = 0;
 		while( !enemy.isEmpty() ) {			
 			for (int i = 0; i < 3; i++) {
 				int dMin = Integer.MAX_VALUE;
 				for (int j = 0; j < enemy.size(); j++) {
 					int d = 0;
 					int y = Math.abs(N - enemy.get(j).y);
 					int x = Math.abs(archor[i] - enemy.get(j).x);
 					d = y + x;
 					enemy.get(j).d = d;
 					dMin = Math.min(dMin, d);
				}
 				for (int j = 0; j < enemy.size(); j++) {
 					int temp = enemy.get(j).d;
					if(temp <= D && temp == dMin) kill.add(enemy.get(j));
				}
 				if( !kill.isEmpty() && !enemy.get(enemy.indexOf(kill.peek())).dead ) {
 					enemy.get(enemy.indexOf(kill.poll())).dead = true;
 	 				killed++; 					
 				}
 				kill.clear();
			} 			
 			for (int i = 0; i < enemy.size(); i++) {
				if(++enemy.get(i).y == N || enemy.get(i).dead ) {
					enemy.remove(i);
					i--;
				}				
			} 	
 		}
 		max = Math.max(max, killed); 
 		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) enemy.add(new Enemy(i, j));
			}
		}
 	}
 	static class Enemy implements Comparable<Enemy>{
 		int y, x, d;
 		boolean dead;
 		
 		Enemy(int y, int x) {
 			this.y = y;
 			this.x = x;
 		}

		@Override
		public int compareTo(Enemy o) {			
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "Enemy [y=" + y + ", x=" + x + ", d=" + d + ", dead=" + dead + "]";
		} 		
 	}
}
