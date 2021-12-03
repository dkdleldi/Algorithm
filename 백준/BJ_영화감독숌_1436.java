package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_영화감독숌_1436 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int six = 666;
		int idx = 1;
		while(true) {
			if(idx == N) break;
			six++;
			if(Integer.toString(six).contains("666")) idx++;
		}
		System.out.println(six);
	}
}
