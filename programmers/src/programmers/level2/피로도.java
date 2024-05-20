package programmers.level2;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {
	 
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
//    	explore(new int[dungeons.length], k, dungeons);
        explore2(new boolean[dungeons.length], k, dungeons, 0);
        
        return max;
    }
    
    
    public void explore(int[] doneTmp, int rest, int[][] dungeons){
    	
    	/**
    	 * 	테스트 1 〉	통과 (0.11ms, 75.9MB)
			테스트 2 〉	통과 (0.10ms, 76.3MB)
			테스트 3 〉	통과 (0.08ms, 77.3MB)
			테스트 4 〉	통과 (0.41ms, 75.8MB)
			테스트 5 〉	통과 (1.65ms, 75.4MB)
			테스트 6 〉	통과 (2.91ms, 82.2MB)
			테스트 7 〉	통과 (9.16ms, 93.8MB)
			테스트 8 〉	통과 (26.85ms, 96.9MB)
			테스트 9 〉	통과 (0.15ms, 78.6MB)
			테스트 10 〉	통과 (1.64ms, 73.3MB)
			테스트 11 〉	통과 (0.11ms, 73.6MB)
			테스트 12 〉	통과 (2.01ms, 78.3MB)
			테스트 13 〉	통과 (0.70ms, 77.4MB)
			테스트 14 〉	통과 (0.46ms, 78.3MB)
			테스트 15 〉	통과 (0.21ms, 75.9MB)
			테스트 16 〉	통과 (0.20ms, 73.1MB)
			테스트 17 〉	통과 (0.45ms, 75.2MB)
			테스트 18 〉	통과 (0.07ms, 70.2MB)
			테스트 19 〉	통과 (0.32ms, 70.4MB)
    	 */
        
        if(rest < 0) return;
        
        if(_getCountOfDone(doneTmp) == doneTmp.length) return;
        
        for(int i = 0; i < doneTmp.length; i++){
            int[] done = Arrays.copyOf(doneTmp, doneTmp.length);
            if(done[i] == 0){
                if(rest < dungeons[i][0]){
                    max = Math.max(max, _getCountOfDone(done));
                }else{
                    done[i] = 1;
                    max = Math.max(max, _getCountOfDone(done));
                    explore(done, rest - dungeons[i][1], dungeons);
                }
            }
        }
    }

    public void explore2(boolean[] done, int rest, int[][] dungeons, int maxTmp){
    	
    	/**
    	 * 	테스트 1 〉	통과 (0.04ms, 75.3MB)
			테스트 2 〉	통과 (0.04ms, 71MB)
			테스트 3 〉	통과 (0.04ms, 76.7MB)
			테스트 4 〉	통과 (0.21ms, 72.5MB)
			테스트 5 〉	통과 (0.48ms, 70.7MB)
			테스트 6 〉	통과 (0.58ms, 74.6MB)
			테스트 7 〉	통과 (1.44ms, 73.2MB)
			테스트 8 〉	통과 (2.98ms, 75.1MB)
			테스트 9 〉	통과 (0.04ms, 74.5MB)
			테스트 10 〉	통과 (0.55ms, 74.7MB)
			테스트 11 〉	통과 (0.03ms, 70.8MB)
			테스트 12 〉	통과 (0.72ms, 72.7MB)
			테스트 13 〉	통과 (0.19ms, 77.4MB)
			테스트 14 〉	통과 (0.08ms, 74.6MB)
			테스트 15 〉	통과 (0.05ms, 74.8MB)
			테스트 16 〉	통과 (0.05ms, 80MB)
			테스트 17 〉	통과 (0.10ms, 75.4MB)
			테스트 18 〉	통과 (0.04ms, 65.8MB)
			테스트 19 〉	통과 (0.05ms, 73.5MB)
    	 */
    	
    	for(int i = 0; i < dungeons.length; i++) {
    		if(!done[i] && rest - dungeons[i][0] >= 0) {
    			done[i] = true;
    			max = Math.max(max, maxTmp + 1);
    			explore2(done, rest - dungeons[i][1], dungeons, maxTmp+1);
    			done[i] = false;
    		}
    	}
    }
    
    public int _getCountOfDone(int[] done){
        int count = 0;
        for(int d : done){
            if(d == 1){
                count++;
            }
        }
        return count;
    }
}
