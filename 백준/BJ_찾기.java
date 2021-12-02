package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_찾기 {

	static char[] T, P;
	static int cnt;
	static ArrayList<Integer> list;
	static int[] pi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		list = new ArrayList<>();
		pi = new int[P.length];
		
		int j = 0;
		for (int i = 1; i < P.length; i++) {
			while(j > 0 && P[i] != P[j]) j = pi[j-1];		
			if(P[i] == P[j]) pi[i] = ++j;
		}
		
		j = 0;
		for (int i = 0; i < T.length; i++) {
			while(j > 0 && T[i] != P[j]) j = pi[j-1];
			if(T[i] == P[j]) {
				if(j == P.length-1) {
					cnt++;
					list.add(i+2-P.length);
					j = pi[j];
				}
				else j++;
			}
		}
		
		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
