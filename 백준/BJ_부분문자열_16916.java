package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_부분문자열_16916 {

	static char[] S, P;
	static int[] pi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		pi = new int[P.length];
		int j = 0;
		for (int i = 1; i < P.length; i++) {
			while(j > 0 && P[i] != P[j]) j = pi[j-1];
			if(P[i] == P[j]) pi[i] = ++j;
		}
		
		j = 0;
		for (int i = 0; i < S.length; i++) {
			while(j > 0 && S[i] != P[j]) j = pi[j-1];
			if(S[i] == P[j]) {
				if(j == P.length-1) {
					System.out.println(1);
					return;
				}
				else ++j;
			}
		}
		System.out.println(0);
	}
}
