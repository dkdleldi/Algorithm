import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스위치켜고끄기_1244 {
	static int switchNum, studentNum;
	static int[] switchStatus, studentGender, studentSwitch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		switchNum = Integer.parseInt(br.readLine());
		switchStatus = new int[switchNum+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switchNum; i++) {		
			switchStatus[i] = Integer.parseInt(st.nextToken());
		}
		studentNum = Integer.parseInt(br.readLine());
		studentGender = new int[studentNum];
		studentSwitch = new int[studentNum];
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			studentGender[i] = Integer.parseInt(st.nextToken());
			studentSwitch[i] = Integer.parseInt(st.nextToken());
		}
		
//		for (int i = 1; i <= switchNum; i++) {
//			System.out.print(switchStatus[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < studentNum; i++) {
//			System.out.print(studentGender[i] + " " + studentSwitch[i]);
//			System.out.println();
//		}
		
		for (int i = 0; i < studentNum; i++) {
			if(studentGender[i] == 1) {
				for (int j = 1; j <= switchNum; j++) {
					if(j % studentSwitch[i] == 0) {
						if(switchStatus[j] == 1) switchStatus[j] = 0;
						else switchStatus[j] = 1;
					}
				}
			}
			else if(studentGender[i] == 2) {
				int j=0;
				do {
					if(switchStatus[studentSwitch[i]-j] == 1) {
						switchStatus[studentSwitch[i]-j] = 0;
						switchStatus[studentSwitch[i]+j] = 0;
					}
					else {
						switchStatus[studentSwitch[i]-j] = 1;
						switchStatus[studentSwitch[i]+j] = 1;
					}
					j++;
				} while(studentSwitch[i]-j >= 1 && studentSwitch[i]+j <= switchNum
						&& switchStatus[studentSwitch[i]-j] == switchStatus[studentSwitch[i]+j]);
			}
		}
		for (int i = 1; i <= switchNum; i++) {
			System.out.print(switchStatus[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
