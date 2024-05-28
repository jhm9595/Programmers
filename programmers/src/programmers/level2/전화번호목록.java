package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 전화번호목록 {
	public static void main(String[] args) {
//		String[] phone_book = {"1235","12","123","567","88"};
//		String[] phone_book = {"123","456","789"};
//		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"56", "57", "580","590","599"};
		solution(phone_book);
	}
	
	public static boolean solution(String[] phone_book) {
		
		/** 정확성 테스트 */ 
//		테스트 1 〉	통과 (0.46ms, 76.7MB)
//		테스트 2 〉	통과 (0.50ms, 78.1MB)
//		테스트 3 〉	통과 (0.51ms, 74.4MB)
//		테스트 4 〉	통과 (0.42ms, 81.2MB)
//		테스트 5 〉	통과 (0.62ms, 73.2MB)
//		테스트 6 〉	통과 (0.52ms, 79.1MB)
//		테스트 7 〉	통과 (0.83ms, 73.5MB)
//		테스트 8 〉	통과 (0.45ms, 77.1MB)
//		테스트 9 〉	통과 (0.47ms, 77.3MB)
//		테스트 10 〉	통과 (0.57ms, 76MB)
//		테스트 11 〉	통과 (0.71ms, 77.6MB)
//		테스트 12 〉	통과 (0.45ms, 75.9MB)
//		테스트 13 〉	통과 (0.63ms, 72.1MB)
//		테스트 14 〉	통과 (6.21ms, 72.2MB)
//		테스트 15 〉	통과 (6.74ms, 86.4MB)
//		테스트 16 〉	통과 (4.59ms, 74.1MB)
//		테스트 17 〉	통과 (7.75ms, 84.7MB)
//		테스트 18 〉	통과 (7.42ms, 78.7MB)
//		테스트 19 〉	통과 (6.56ms, 84MB)
//		테스트 20 〉	통과 (9.46ms, 92MB)
		
		/** 효율성 테스트 */ 
//		테스트 1 〉	통과 (0.64ms, 59.6MB)
//		테스트 2 〉	통과 (0.58ms, 57.1MB)
//		테스트 3 〉	통과 (339.52ms, 101MB)
//		테스트 4 〉	통과 (106.70ms, 96.1MB)
		
		Map<Character, Set<String>> map = new HashMap<>();
		
        Character c;
        
        Set<String> set;
        String h;
        String l;
        for(String s : phone_book){
            c = s.charAt(0);
            if(map.get(c) == null){
                map.put(c, new HashSet<String>());
            }
            
            set = map.get(c);
            for(int i = 1; i < set.size(); i++) {
            	if(set.contains(s.substring(0, i))) {
            		return false;
            	}
            }
            set.add(s);
        }
        
        return true;
    }
	
	public static boolean solution2(String[] phone_book) {
		//
//		테스트 1 〉	통과 (0.16ms, 82.3MB)
//		테스트 2 〉	통과 (0.10ms, 75.4MB)
//		테스트 3 〉	통과 (0.12ms, 73.7MB)
//		테스트 4 〉	통과 (0.13ms, 72.1MB)
//		테스트 5 〉	통과 (0.19ms, 74.2MB)
//		테스트 6 〉	통과 (0.13ms, 76.1MB)
//		테스트 7 〉	통과 (0.14ms, 77.2MB)
//		테스트 8 〉	통과 (0.11ms, 84.3MB)
//		테스트 9 〉	통과 (0.11ms, 76.1MB)
//		테스트 10 〉	통과 (0.12ms, 74.1MB)
//		테스트 11 〉	통과 (0.13ms, 74MB)
//		테스트 12 〉	통과 (0.12ms, 78.6MB)
//		테스트 13 〉	통과 (0.14ms, 77.6MB)
//		테스트 14 〉	통과 (2.37ms, 88.1MB)
//		테스트 15 〉	통과 (1.83ms, 79.2MB)
//		테스트 16 〉	통과 (6.79ms, 83.9MB)
//		테스트 17 〉	통과 (8.86ms, 86.5MB)
//		테스트 18 〉	통과 (10.13ms, 77.7MB)
//		테스트 19 〉	통과 (4.06ms, 86MB)
//		테스트 20 〉	통과 (4.84ms, 82.3MB)
		
		//
//		테스트 1 〉	통과 (3.55ms, 56.5MB)
//		테스트 2 〉	통과 (2.97ms, 56.5MB)
//		테스트 3 〉	통과 (255.11ms, 243MB)
//		테스트 4 〉	통과 (198.77ms, 135MB)
		Set<String> set = new HashSet<>(Arrays.asList(phone_book));
		for (String v : phone_book) {
			for (int idx = 1; idx < v.length(); ++idx) {
				if (set.contains(v.substring(0, idx))) {
					return false;
				}
			}
		}
		return true;
	}
	
}
