package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_치킨배달 {
	static int N, M, min, chickenCnt, homeCnt;
 	static int[][] map;
	static int[][] tgt;
 	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					int[] temp = {i, j};
					home.add(temp);
					homeCnt++;
				}
				else if(map[i][j] == 2) {
					int[] temp = {i, j};
					chicken.add(temp);
					chickenCnt++;
				}
			}
		}
		tgt = new int[M][2];		
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if( tgtIdx == M ) {
			int[] dMin = new int[homeCnt];
			Arrays.fill(dMin, Integer.MAX_VALUE);
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < homeCnt; j++) {
					int d = 0;
					int y = Math.abs(tgt[i][0] - home.get(j)[0]);
					int x = Math.abs(tgt[i][1] - home.get(j)[1]);
					d += y+x;
					dMin[j] = Math.min(dMin[j], d);
				}
			}
			int sum = 0;
			for (int i = 0; i < homeCnt; i++) {
				sum += dMin[i];
			}
			min = Math.min(min, sum);
			return;
		}
		if( srcIdx == chickenCnt ) return;
		
		tgt[tgtIdx] = chicken.get(srcIdx);
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
		
	}

}
