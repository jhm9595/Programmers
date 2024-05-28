package programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * @author 전형민
 *
 */
public class 타겟넘버 {
	    
    int answer = 0;
    int target = 0;
    
    public int solution(int[] numbers, int target) {
        
        this.target = target;
        
        _findAnswer(numbers, 0, 0, "");
        
        return answer;
    }
    
    public void _findAnswer(int[] numbers, int idx, int sum, String s){
        
        if(idx >= numbers.length){
            if(sum == target) {
                System.out.println("s : " + s);
                answer++;
            }
            return;
        }
        
        _findAnswer(numbers, idx+1, sum + numbers[idx], s + "+" + numbers[idx]);

        _findAnswer(numbers, idx+1, sum + (numbers[idx] * -1), s+(numbers[idx] * -1));
    }
}
