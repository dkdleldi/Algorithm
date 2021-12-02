package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_괄호짝짓기 {

	static int L, cor;
	static char[] par;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1218_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			L = Integer.parseInt(br.readLine());
			par = new char[L];
			par = br.readLine().toCharArray();
			Stack<Character> one = new Stack<>();
			Stack<Character> two = new Stack<>();
			Stack<Character> three = new Stack<>();
			Stack<Character> four = new Stack<>();
			
			for (int i = 0; i < L; i++) {
				switch (par[i]) {
				case '(':
					one.push(par[i]);
					break;
				case '[':
					two.push(par[i]);
					break;
				case '{':
					three.push(par[i]);
					break;
				case '<':
					four.push(par[i]);
					break;
				case ')':
					if(one.isEmpty()) {
						one.push(par[i]);
					}
					else one.pop();
					break;
				case ']':
					if(two.isEmpty()) {
						two.push(par[i]);
					}
					else two.pop();
					break;
				case '}':
					if(three.isEmpty()) {
						three.push(par[i]);
					}
					else three.pop();
					break;
				case '>':
					if(four.isEmpty()) {
						four.push(par[i]);
					}
					else four.pop();
					break;
				}
				if(one.isEmpty() && two.isEmpty() && three.isEmpty() && four.isEmpty() ) {
					cor = 1;
				}
				else cor = 0;
			}
			System.out.println("#" + t + " " + cor);
		}

	}
}
