package pg;

import java.util.Arrays;

public class PG_완주하지못한선수2 {

	public static void main(String[] args) throws Exception {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));

	}

	static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        boolean com = false;
        for (int i = 0; i < participant.length-1; i++) {
        	if(!participant[i].equals(completion[i])) {
        		answer = participant[i];
        		com = true;
        		break;
        	}
		}
        if(!com) answer = participant[participant.length-1];
        return answer;
    }
}
