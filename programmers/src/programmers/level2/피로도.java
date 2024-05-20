package programmers.level2;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {
	 
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
//    	explore(new boolean[dungeons.length], k, dungeons, 0);
        explore2(new boolean[dungeons.length], k, dungeons, 0);
        
        return max;
    }
    
    
    public void explore(int[] doneTmp, int rest, int[][] dungeons){
        
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
