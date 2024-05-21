package programmers.level2.kakaoblind1차;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 
 * @author 전형민
 */
public class 뉴스클러스터링 {

	public int solution(String str1, String str2) {
		
		/*
		테스트 1 〉	통과 (1.78ms, 82.7MB)
		테스트 2 〉	통과 (1.31ms, 88.7MB)
		테스트 3 〉	통과 (1.43ms, 74.3MB)
		테스트 4 〉	통과 (3.73ms, 79.9MB)
		테스트 5 〉	통과 (1.17ms, 79.8MB)
		테스트 6 〉	통과 (1.33ms, 75.5MB)
		테스트 7 〉	통과 (1.69ms, 73.8MB)
		테스트 8 〉	통과 (1.25ms, 84.9MB)
		테스트 9 〉	통과 (2.18ms, 73.6MB)
		테스트 10 〉	통과 (2.47ms, 79.1MB)
		테스트 11 〉	통과 (3.34ms, 74.1MB)
		테스트 12 〉	통과 (1.06ms, 75.5MB)
		테스트 13 〉	통과 (1.97ms, 74.7MB)
		*/

		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// 교집합
		Map<String, Integer> map = new HashMap<>();

		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			String key = str1.substring(i, i + 2);
			if (_checkABC(key)) {
				map1.put(key, map1.getOrDefault(key, 0) + 1);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			String key = str2.substring(i, i + 2);
			if (_checkABC(key)) {
				map2.put(key, map2.getOrDefault(key, 0) + 1);
			}
		}

		if (map1.size() == 0 && map2.size() == 0)
			return _calAnswer(BigDecimal.ONE);

		if (map1.size() == 0 || map2.size() == 0)
			return _calAnswer(BigDecimal.ZERO);

		for (Entry<String, Integer> e : map1.entrySet()) {
			String key = e.getKey();
			int val = e.getValue();
			if (map2.getOrDefault(key, 0) > 0) {
				int sub = Math.min(val, map2.get(key));
				map.put(key, map.getOrDefault(key, 0) + sub);
				map1.put(key, map1.get(key) - sub);
				map2.put(key, map2.get(key) - sub);
			}
		}
		BigDecimal mapCnt = _countMapAsBigDecimal(map);

		BigDecimal tmp = mapCnt.add(_countMapAsBigDecimal(map1)).add(_countMapAsBigDecimal(map2));

		BigDecimal ans = mapCnt.divide(tmp, MathContext.DECIMAL64);

		return _calAnswer(ans);
	}
	
	public int solution2(String str1, String str2) {
		
		/*
		테스트 1 〉	통과 (1.32ms, 72.3MB)
		테스트 2 〉	통과 (1.35ms, 69.2MB)
		테스트 3 〉	통과 (1.54ms, 69MB)
		테스트 4 〉	통과 (3.68ms, 71MB)
		테스트 5 〉	통과 (1.42ms, 76.4MB)
		테스트 6 〉	통과 (1.13ms, 79.9MB)
		테스트 7 〉	통과 (2.00ms, 77MB)
		테스트 8 〉	통과 (1.66ms, 83.8MB)
		테스트 9 〉	통과 (1.54ms, 76.4MB)
		테스트 10 〉	통과 (2.56ms, 76.6MB)
		테스트 11 〉	통과 (2.72ms, 74.3MB)
		테스트 12 〉	통과 (1.16ms, 81.5MB)
		테스트 13 〉	통과 (1.22ms, 72.2MB)
		*/
		
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		// 교집합
		Map<String, Integer> map = new HashMap<>();
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < str1.length() - 1; i++) {
			String key = str1.substring(i, i + 2);
			if (_checkABC(key)) {
				map1.put(key, map1.getOrDefault(key, 0) + 1);
			}
		}
		
		for (int i = 0; i < str2.length() - 1; i++) {
			String key = str2.substring(i, i + 2);
			if (_checkABC(key)) {
				map2.put(key, map2.getOrDefault(key, 0) + 1);
			}
		}
		
		if (map1.size() == 0 && map2.size() == 0)
			return _calAnswer(BigDecimal.ONE);
		
		if (map1.size() == 0 || map2.size() == 0)
			return _calAnswer(BigDecimal.ZERO);
		
		for (Entry<String, Integer> e : map1.entrySet()) {
			String key = e.getKey();
			int val = e.getValue();
			if (map2.getOrDefault(key, 0) > 0) {
				int sub = Math.min(val, map2.get(key));
				map.put(key, map.getOrDefault(key, 0) + sub);
				map1.put(key, map1.get(key) - sub);
				map2.put(key, map2.get(key) - sub);
			}
		}
		
		BigDecimal mapCnt = _countMapAsBigDecimal(map);
		
		return _calAnswer(mapCnt.divide(mapCnt.add(_countMapAsBigDecimal(map1)).add(_countMapAsBigDecimal(map2)), MathContext.DECIMAL64));
	}
	
	static final float divisor = 65536f;

	public int solution3(String str1, String str2) {
		
		/*
		테스트 1 〉	통과 (0.17ms, 71.2MB)
		테스트 2 〉	통과 (0.19ms, 71.7MB)
		테스트 3 〉	통과 (0.09ms, 64.3MB)
		테스트 4 〉	통과 (4.29ms, 81.4MB)
		테스트 5 〉	통과 (0.16ms, 73.1MB)
		테스트 6 〉	통과 (0.18ms, 74.3MB)
		테스트 7 〉	통과 (0.75ms, 71.5MB)
		테스트 8 〉	통과 (0.17ms, 75.6MB)
		테스트 9 〉	통과 (0.53ms, 62.4MB)
		테스트 10 〉	통과 (0.84ms, 71.7MB)
		테스트 11 〉	통과 (1.30ms, 78MB)
		테스트 12 〉	통과 (0.07ms, 75.5MB)
		테스트 13 〉	통과 (0.50ms, 73.1MB)
		*/
		
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		// 교집합
		Map<String, Integer> map = new HashMap<>();
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < str1.length() - 1; i++) {
			String key = str1.substring(i, i + 2);
			if (_checkABC(key)) {
				map1.put(key, map1.getOrDefault(key, 0) + 1);
			}
		}
		
		for (int i = 0; i < str2.length() - 1; i++) {
			String key = str2.substring(i, i + 2);
			if (_checkABC(key)) {
				map2.put(key, map2.getOrDefault(key, 0) + 1);
			}
		}
		
		if (map1.size() == 0 && map2.size() == 0)
			return (int) divisor;
		
		if (map1.size() == 0 || map2.size() == 0)
			return 0;
		
		for (Entry<String, Integer> e : map1.entrySet()) {
			String key = e.getKey();
			int val = e.getValue();
			if (map2.getOrDefault(key, 0) > 0) {
				int sub = Math.min(val, map2.get(key));
				map.put(key, map.getOrDefault(key, 0) + sub);
				map1.put(key, map1.get(key) - sub);
				map2.put(key, map2.get(key) - sub);
			}
		}
		
		float mapCnt = _countMap(map.values());
		float ans = mapCnt / (mapCnt + _countMap(map1.values()) + _countMap(map2.values())) * divisor;
		
		return (int) ans;
	}

	private int _countMap(Collection<Integer> values) {
		int cnt = 0;

		for (int n : values) {
			cnt += n;
		}
		return cnt;
	}

	public BigDecimal _countMapAsBigDecimal(Map<String, Integer> map) {
		int cnt = 0;

		for (int n : map.values()) {
			cnt += n;
		}

		return new BigDecimal(cnt);
	}
	

	public float _countMapAsFloat(Map<String, Integer> map) {
		float cnt = 0;
		
		for (float n : map.values()) {
			cnt += n;
		}
		
		return cnt;
	}
	
	public int _countMap(Map<String, Integer> map) {
		int cnt = 0;
		
		for (int n : map.values()) {
			cnt += n;
		}
		
		return cnt;
	}

	public boolean _checkABC(String s) {
		s = s.toUpperCase();
		for (char c : s.toCharArray()) {
			if (!(65 <= c && c <= 90)) {
				return false;
			}
		}
		return true;
	}

	public int _calAnswer(BigDecimal f) {
		return f.multiply(new BigDecimal(divisor))
				.setScale(0, RoundingMode.FLOOR)
				.intValue();
	}
}