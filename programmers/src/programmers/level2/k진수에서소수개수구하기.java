package programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * @author 전형민
 * 1) 에라토스테네스의 체 알고리즘.
 * 2) 소수는 루트를 이용해서 찾을 것!
 */
public class k진수에서소수개수구하기 {

	public int solution(int n, int k) {
		
		int answer = 0;
		for(String s : Integer.toString(n,k).split("0")){
			
			if(s.equals("") || s.equals("1")) continue;
			
			answer += _isPrimeNumber(Long.valueOf(s));
		}
		return answer;
    }
    
    
	private int _isPrimeNumber(Long l) {
		for(long i = 2; i <= Math.sqrt(l); i++){
			if(l % i == 0){
				return 0;
			}
		}
		return 1;
	}
}
