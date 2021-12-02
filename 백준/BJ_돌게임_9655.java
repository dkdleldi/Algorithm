package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_돌게임_9655 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N%2 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}
