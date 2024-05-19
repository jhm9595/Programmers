package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class 튜플 {
	public static void main(String[] args) {

		String s = "{{2,1,3},{2},{2,1},{2,1,3,4}}";
		solution2(s);

	}

	public static int[] solution(String s) {

		// 앞 뒤의 '{{' 와 '}}' 제거 => },{로 split
		String[] strArr = s.substring(2, s.length() - 2).split("\\},\\{");

		// 요소별 갯수로 정렬
		Arrays.sort(strArr, (a,b) -> a.length() - b.length());
		
		// 순서가 유지되는 LinkedHashSet에 저장
		Set<String> set = new LinkedHashSet<>();
		for(String str : strArr) {
			for(String tmp : str.split(",")) {
				if(set.add(tmp)) break;
			}
		}
		
		// Set을 int Array로 변환
		return set.stream().mapToInt(Integer::parseInt).toArray();
	}

	public static int[] solution2(String s) {
		
		/**
		 * 충격적인 소스 예시
		 * 1) {,} 를 모두 삭제
		 * 2) 들어있는 숫자를 map에 갯수를 센다.
		 * 3) 갯수별로 내림차순 정렬
		 * 4) Map => Array
		 * key : 2 / value : 4
		 * key : 1 / value : 3
		 * key : 3 / value : 2
		 * key : 4 / value : 1
		 */

		Map<Integer, Integer> counts = new LinkedHashMap<>();
		
		Stream.of(s.replaceAll("[}{]", "").split(","))
				.mapToInt(Integer::parseInt)
				.forEach(i -> counts.merge(i, 1, Integer::sum));
		
		return counts.entrySet()
				.stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.mapToInt(Map.Entry::getKey)
				.toArray();

	}
	

	public static int[] solution3(String s) {
		
		/**
		 * 충격적인 소스 예시
		 * 1) {,} 를 모두 삭제
		 * 2) 들어있는 숫자를 map에 갯수를 센다.
		 * 3) 갯수별로 내림차순 정렬
		 * 4) Map => Array
		 * key : 2 / value : 4
		 * key : 1 / value : 3
		 * key : 3 / value : 2
		 * key : 4 / value : 1
		 */

		Map<String, Integer> counts = new HashMap<>();
		
		for(String c : s.replaceAll("[}{]", "").split(",")) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}
		
		
		
		return counts.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		.mapToInt(io-> Integer.parseInt(io.getKey()))
		.toArray();
	}
}
