package programmers.level2;

import java.util.Arrays;

public class 기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int days = 0;
        int aswrIdx = -1;
        
        for (int idx = 0; idx < speeds.length; idx++) {
        	
        	int speed = speeds[idx];
        	
            int sum = days * speed + progresses[idx];
            
            if (sum < 100) {
            	
                int rest = 100 - sum;
                
                days += rest % speed == 0 ? rest / speed : rest / speed + 1;
                
                answer[++aswrIdx]++;
                
                if(idx == speeds.length) {
                	aswrIdx--;
                }
                
            } else {
                answer[aswrIdx]++;
            }
        }
        return Arrays.copyOfRange(answer, 0, aswrIdx+1);
    }
	

	public int[] solution2(int[] progresses, int[] speeds) {
		
		int[] days = new int[speeds.length];
		
		for(int i = 0; i < speeds.length; i++) {
			int prgs = progresses[i];
			int spd = speeds[i];
			
			days[i] = prgs / spd + (prgs % spd == 0 ? 0 : 1);
		}
		
		int max = days[0];
		int idx = 0;
		int answer[] = new int[days.length];
		for(int day : days) {
			int tmp = Math.max(max, day);
			if(max != tmp) {
				max = tmp;
				idx++;
				answer[idx]++;
			}else if(max == tmp) {
				answer[idx]++;
			}else if(day == 0){
				break;
			}
		}
		
		return Arrays.copyOf(answer, idx+1);
    }		
}
