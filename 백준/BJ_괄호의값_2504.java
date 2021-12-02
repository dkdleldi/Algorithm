package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_괄호의값_2504 {

	static char[] c;
	static Stack<Character> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = br.readLine().toCharArray();
		stack = new Stack<>();
		long ans = 0;
		long temp = 1;
		boolean invalid = false;
		
		for (int i = 0; i < c.length; i++) {
			if(c[i] == '(') {
				stack.push(c[i]);
				temp *= 2;
			}
			else if(c[i] == '[') {
				stack.push(c[i]);
				temp *= 3;
			}
			else if(c[i] == ')') {
				if(stack.isEmpty() || stack.peek() == '[') {
					invalid = true;
					break;
				}
				else if(i-1 >= 0 && c[i-1] == '(') ans += temp;
				stack.pop();
				temp /= 2;
			}
			else if(c[i] == ']') {
				if(stack.isEmpty() || stack.peek() == '(') {
					invalid = true;
					break;
				}
				else if(i-1 >= 0 && c[i-1] == '[') ans += temp;
				stack.pop();
				temp /= 3;
			}
			if(invalid) break;
		}
		if(invalid || !stack.isEmpty()) System.out.println(0);
		else System.out.println(ans);
	}
}
