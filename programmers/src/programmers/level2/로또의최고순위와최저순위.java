package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import common.CommonUtils;

public class 로또의최고순위와최저순위 {
	
	public static void main(String[] args) {
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		CommonUtils.printArray(solution(lottos, win_nums));
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		
//		[44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]
//				기댓값 〉	[3, 5]
		
//		0,0,
//		1,  25,31,44 
//		1,6,19,31,45
//		
//		1, 31
//		
//		2개 또는 4
		
		// 맞은갯수 / 등
		Map<Integer, Integer> lottoMap = new HashMap<Integer, Integer>();
		lottoMap.put(6, 1);
		lottoMap.put(5, 2);
		lottoMap.put(4, 3);
		lottoMap.put(3, 4);
		lottoMap.put(2, 5);
		lottoMap.put(1, 6);
		lottoMap.put(0, 6);
			
        Arrays.sort(lottos);
        
        CommonUtils.printArray(lottos);
        
        Arrays.sort(win_nums);
        
        CommonUtils.printArray(win_nums);
        
        int zeroCnt = 0;
        int idx = 0;
        int hitCnt = 0;
        for(int i = 0; i < lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zeroCnt++;
        	}else {
        		while(idx < win_nums.length && lottos[i] >= win_nums[idx]) {
        			System.out.println("lottos[" + i + "] : " + lottos[i]);
        			System.out.println("win_nums[" + idx + "] : " + win_nums[idx]);
        			System.out.println("----");
        			
	        		if(lottos[i] == win_nums[idx++]){
	        			System.out.println("hit :" + lottos[i]);
	        			hitCnt++;
	        			break;
	        		}
        		}
        	}
        }
        
        System.out.println("hitCnt : "+ hitCnt);
        System.out.println("zeroCnt : "+ zeroCnt);
       
        return new int[] {lottoMap.get(hitCnt+zeroCnt), lottoMap.get(hitCnt)};
    }
}
