package pg;

import java.util.Arrays;

public class PG_모의고사 {

	public static void main(String[] args) throws Exception {
		int[] answers = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(solution(answers)));
	}

	static int[] solution(int[] answers) {
        int[] answer;
        int len = answers.length;
        int[][] supo = new int[3][len];
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				int ni1 = 0;
				for (int j = 0; j < len; j++) {
					if(ni1 == 5) ni1 = 0;
					supo[i][j] = num1[ni1++];
				}
				break;
			case 1:
				int ni2 = 0;
				for (int j = 0; j < len; j++) {
					if(ni2 == 8) ni2 = 0;
					supo[i][j] = num2[ni2++];
				}
				break;
			case 2:
				int ni3 = 0;
				for (int j = 0; j < len; j++) {
					if(ni3 == 10) ni3 = 0;
					supo[i][j] = num3[ni3++];
				}
				break;
			}
		}
        int[] cor = new int[3];
        int max = 0;
        int size = 0;
        for (int i = 0; i < 3; i++) {
			for (int j = 0; j < len; j++) {
				if(answers[j] == supo[i][j]) cor[i]++;
			}
			if(max < cor[i]) {
				max = cor[i];
				size = 1;
			}
			else if(max == cor[i]) size++;
		}
        
        int cori = 0;
        answer = new int[size];
        for (int i = 0; i < 3; i++) {
			if(cor[i] == max) answer[cori++] = i+1;
		}
        return answer;
    }
}
