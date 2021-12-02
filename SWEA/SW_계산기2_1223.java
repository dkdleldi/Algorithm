import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_계산기2_1223 {
	static int len;
	static Stack<Integer> num = new Stack<>();
	static Stack<Character> op = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			char[] cal = br.readLine().toCharArray();			
			for (int i = 0; i < len; i++) {
				if(Character.isDigit(cal[i])) sb.append(cal[i]);
				else {
					if(cal[i] == '+') {
						if(op.isEmpty()) op.push(cal[i]);
						else {
							while(!op.isEmpty()) sb.append(op.pop());
							op.push(cal[i]);
						}
					}
					else if(cal[i] == '*') {
						if(op.isEmpty() || op.peek() == '+') op.push(cal[i]);
						else {
							sb.append(op.pop());
							op.push(cal[i]);
						}
					}
				}
			}
			while(!op.isEmpty()) sb.append(op.pop());
			//System.out.println(sb);
			for (int i = 0; i < len; i++) {
				if(Character.isDigit(sb.charAt(i))) num.add(sb.charAt(i) - '0');
				else if(sb.charAt(i) == '+') num.add(num.pop() + num.pop());
				else if(sb.charAt(i) == '*') num.add(num.pop() * num.pop());
			}
			System.out.println("#" + t + " " + num.pop());
			sb.setLength(0);
		}
	}
}
