package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
	
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println("EXIT : " + solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
		
//		테스트 1 〉	통과 (0.74ms, 76.5MB)
//		테스트 2 〉	통과 (1.44ms, 81.2MB)
//		테스트 3 〉	통과 (1.77ms, 76.1MB)
//		테스트 4 〉	통과 (0.66ms, 73.6MB)
//		테스트 5 〉	통과 (1.67ms, 81.4MB)
//		테스트 6 〉	통과 (0.73ms, 72.5MB)
//		테스트 7 〉	통과 (1.07ms, 74.8MB)
//		테스트 8 〉	통과 (1.65ms, 74.6MB)
//		테스트 9 〉	통과 (0.61ms, 75.9MB)
//		테스트 10 〉	통과 (0.80ms, 75.6MB)
//		테스트 11 〉	통과 (1.38ms, 76.8MB)
//		테스트 12 〉	통과 (0.80ms, 78.2MB)
//		테스트 13 〉	통과 (0.93ms, 71.9MB)
//		테스트 14 〉	통과 (0.77ms, 74.7MB)
//		테스트 15 〉	통과 (1.40ms, 78.4MB)
//		테스트 16 〉	통과 (1.56ms, 77.4MB)
//		테스트 17 〉	통과 (1.07ms, 74.4MB)
//		테스트 18 〉	통과 (1.68ms, 77.1MB)
//		테스트 19 〉	통과 (0.96ms, 73.5MB)
//		테스트 20 〉	통과 (0.66ms, 77.6MB)
		
		Queue<Item> q = new LinkedList<>();
		
		int idx = 0;
		for(int p : priorities) {
			q.add(new Item(idx++, p));
		}
		
		Arrays.sort(priorities);
		
		// Priority 순
		Queue<Integer> qDsc = new LinkedList<>();
		
		for(int i = priorities.length-1; i >= 0; i--) {
			qDsc.add(priorities[i]);
		}
		
		int answer = 1;
		while(qDsc.size() > 0) {
			Item n = q.poll();
			if(qDsc.peek() == n.priority) {
				qDsc.poll();
				
				if(n.idx == location) {
					return answer;
				}else {
					answer++;
				}
			}else {
				q.add(n);
			}
		}
		
        return answer;
    }
	
	public static int solution2(int[] priorities, int location) {
//		테스트 1 〉	통과 (1.21ms, 84.1MB)
//		테스트 2 〉	통과 (1.95ms, 78MB)
//		테스트 3 〉	통과 (0.85ms, 75MB)
//		테스트 4 〉	통과 (1.16ms, 77MB)
//		테스트 5 〉	통과 (0.66ms, 76.5MB)
//		테스트 6 〉	통과 (1.23ms, 74.4MB)
//		테스트 7 〉	통과 (0.83ms, 73.4MB)
//		테스트 8 〉	통과 (1.40ms, 73.3MB)
//		테스트 9 〉	통과 (0.75ms, 85.2MB)
//		테스트 10 〉	통과 (0.81ms, 77MB)
//		테스트 11 〉	통과 (1.23ms, 79.1MB)
//		테스트 12 〉	통과 (0.74ms, 74.9MB)
//		테스트 13 〉	통과 (1.02ms, 73.7MB)
//		테스트 14 〉	통과 (0.73ms, 73.9MB)
//		테스트 15 〉	통과 (0.94ms, 77.3MB)
//		테스트 16 〉	통과 (1.38ms, 75.7MB)
//		테스트 17 〉	통과 (1.43ms, 78.3MB)
//		테스트 18 〉	통과 (0.77ms, 80.7MB)
//		테스트 19 〉	통과 (1.35ms, 86.9MB)
//		테스트 20 〉	통과 (1.21ms, 77.9MB)
		
		Queue<Item> q = new LinkedList<>();
		PriorityQueue<Integer> qDsc = new PriorityQueue<>(Collections.reverseOrder());
		
		int idx = 0;
		for(int p : priorities) {
			q.add(new Item(idx++, p));
			qDsc.add(p);
		}
		
		int answer = 1;
		while(qDsc.size() > 0) {
			Item n = q.poll();
			if(qDsc.peek() == n.priority) {
				qDsc.poll();
				if(n.idx == location) {
					return answer;
				}else {
					answer++;
				}
			}else {
				q.add(n);
			}
		}
		
		return answer;
	}
	
	public int solution3(int[] priorities, int location) {
		
//		테스트 1 〉	통과 (0.63ms, 74.5MB)
//		테스트 2 〉	통과 (0.94ms, 70.7MB)
//		테스트 3 〉	통과 (0.86ms, 73MB)
//		테스트 4 〉	통과 (0.62ms, 79MB)
//		테스트 5 〉	통과 (0.82ms, 75.8MB)
//		테스트 6 〉	통과 (3.36ms, 76.1MB)
//		테스트 7 〉	통과 (0.55ms, 78.9MB)
//		테스트 8 〉	통과 (0.72ms, 74.6MB)
//		테스트 9 〉	통과 (0.38ms, 74.4MB)
//		테스트 10 〉	통과 (0.50ms, 84.8MB)
//		테스트 11 〉	통과 (0.76ms, 72.7MB)
//		테스트 12 〉	통과 (1.19ms, 74.8MB)
//		테스트 13 〉	통과 (0.83ms, 77.2MB)
//		테스트 14 〉	통과 (0.37ms, 72.6MB)
//		테스트 15 〉	통과 (0.39ms, 76.9MB)
//		테스트 16 〉	통과 (0.43ms, 75.6MB)
//		테스트 17 〉	통과 (0.89ms, 78.4MB)
//		테스트 18 〉	통과 (0.37ms, 74.5MB)
//		테스트 19 〉	통과 (0.87ms, 73.1MB)
//		테스트 20 〉	통과 (0.52ms, 69.9MB)
		
        int answer = 1;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            p.add(priorities[i]);
        }

        while(!p.isEmpty()){
        	
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)p.peek()){
                    if(i == location){
                        return answer;
                    }
                    p.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
	
	public int solution4(int[] priorities, int location) {
        int answer = 0;

        int max = 0;
        int len = priorities.length;

        while (true) {
            answer++;

            max = 0;
            int maxIndex = 0;
            // max 찾기
            for (int i = 0; i < len; i++) {
                if (max < priorities[i]) {
                    max = priorities[i];
                    maxIndex = i;
                }
            }
            // 처음값이 최대값이 아니라면 회전하기 - location 값 변경
            if (maxIndex != 0) {
                int[] tempArr = new int[maxIndex];

                for (int i = 0; i < maxIndex; i++) {
                    tempArr[i] = priorities[i];
                }

                int j;
                for (j = 0; j+maxIndex < len; j++) {
                    priorities[j] = priorities[j+maxIndex];
                }

                for (int i = 0; i < maxIndex; i++) {
                    priorities[j++] = tempArr[i];
                }

                location -= maxIndex;

                if (location < 0) {
                    location += len;
                }

            }

            if (location == 0)
                break;

            for (int i = 1; i < len; i++) {
                priorities[i - 1] = priorities[i];
            }
            location--;
            len--;
        }

        return answer;
    }
	
	static class Item{
		int idx;
		int priority;
		
		public Item(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
		
		@Override
		public String toString() {
			return "idx : " + idx + " / priority : " + priority;
		}
	}
}
