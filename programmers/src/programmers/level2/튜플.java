package programmers.level2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 튜플 {
	public static void main(String[] args) {
		
		String s = "{{2,1,3},{2},{2,1},{2,1,3,4}}";
		solution(s);
		
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

}
