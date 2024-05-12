package programmers.level2;

import common.CommonUtils;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java
 * @author minibig
 *
 */
public class 등굣길 {
	
	public static void main(String[] args) {
		
		int m = 5, n = 4;
		int[][] puddles = {
			{2,2}
		};
		System.out.println(solution(m, n, puddles));
	}

	static final int MOD = 1000000007;
	
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    if (i >= 1 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j];
                    }
                    if (j >= 1 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1];
                    }
                    if (map[i][j] > 1000000007) {
                        map[i][j] %= 1000000007;
                    }
                }
            }
        }
        answer = map[n-1][m-1];
        return answer;
    }
	
	public static int solution2(int m, int n, int[][] puddles) {
		
		int row = m;
		int col = n;
		
        int answer = 0;
        
        // The map that counts how many ways can be reached at that position.
        int[][] map = new int[row][col];
        
        // Set puddle's position by -1 
        for(int[] puddle : puddles) {
        	map[puddle[0] - 1][puddle[1] -1] = -1;
        }
        
        // initialize start position
        int startRow = 0;
        int startCol = 0;
        
//        move(startRow, startCol + 1, row, col, map);
//        move(startRow + 1, startCol, row, col, map);

        map[0][0] = 1;
        for(int i = 0 ; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		
        		if(map[i][j] == -1) continue;
        		
        		if(i-1 >= 0 && map[i-1][j] != -1) {
        			map[i][j] += map[i-1][j];
        		}
        		
        		if(j-1 >= 0 && map[i][j-1] != -1) {
        			map[i][j] += map[i][j-1];
        		}
        	}
        }
        
        answer = map[row -1][col-1];
        
        CommonUtils.print2thArray(map);
        
        return answer % MOD;
    }
	

	private static void move(int row, int col, int maxRow, int maxCol, int[][] map) {
		if(row < maxRow && col < maxCol && map[row][col] != -1) {
			map[row][col] %= 1000000007;
			map[row][col]++;
			move(row+1, col, maxRow, maxCol, map);
			move(row, col+1, maxRow, maxCol, map);
		}
	}
}
