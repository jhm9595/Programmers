package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 의상 {

	public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        
        String key;
        for(String[] io : clothes) {
        	key = io[1];
        	if(map.get(key) == null) {
        		map.put(key, new ArrayList<>());
        	}
            map.get(key).add(io[0]);
        }
        
        int answer = 1;
        
        for(List<String> io : map.values()){
            answer *= (io.size() + 1);
        }
        
        return answer - 1;
        
    }
}

/**
 * 
 * 테스트 1 〉	통과 (0.13ms, 67MB)
테스트 2 〉	통과 (0.06ms, 76.1MB)
테스트 3 〉	통과 (0.08ms, 73.6MB)
테스트 4 〉	통과 (0.06ms, 77.5MB)
테스트 5 〉	통과 (0.05ms, 75.7MB)
테스트 6 〉	통과 (0.05ms, 81.7MB)
테스트 7 〉	통과 (0.11ms, 76.2MB)
테스트 8 〉	통과 (0.09ms, 69.8MB)
테스트 9 〉	통과 (0.05ms, 69.9MB)
테스트 10 〉	통과 (0.07ms, 76.1MB)
테스트 11 〉	통과 (0.05ms, 78MB)
테스트 12 〉	통과 (0.07ms, 75.9MB)
테스트 13 〉	통과 (0.09ms, 77.6MB)
테스트 14 〉	통과 (0.04ms, 75.6MB)
테스트 15 〉	통과 (0.05ms, 83.4MB)
테스트 16 〉	통과 (0.04ms, 78.5MB)
테스트 17 〉	통과 (0.07ms, 66MB)
테스트 18 〉	통과 (0.05ms, 74.3MB)
테스트 19 〉	통과 (0.06ms, 73.2MB)
테스트 20 〉	통과 (0.05ms, 79.4MB)
테스트 21 〉	통과 (0.05ms, 65.7MB)
테스트 22 〉	통과 (0.06ms, 73.6MB)
테스트 23 〉	통과 (0.06ms, 67.9MB)
테스트 24 〉	통과 (0.05ms, 76.1MB)
테스트 25 〉	통과 (0.06ms, 80.6MB)
테스트 26 〉	통과 (0.11ms, 84.4MB)
테스트 27 〉	통과 (0.05ms, 64.7MB)
테스트 28 〉	통과 (0.08ms, 70.7MB)
*/
