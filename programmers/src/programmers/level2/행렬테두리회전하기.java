package programmers.level2;

import common.CommonUtils;

public class 행렬테두리회전하기 {

	
	public static void main(String[] args) {
	
		int rows = 6;
		int columns = 6;
		int[][] queries = {
			{2,2,5,4}
			,{3,3,6,6}
			,{5,1,6,3}
		};
		CommonUtils.printArray(solution(rows, columns, queries));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0 ; i < answer.length; i++) {
        	answer[i] = Integer.MAX_VALUE;
        }
        
        int[][] map = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++) {
        	for(int j = 0 ; j < columns; j++) {
        		map[i][j] = num++; 
        	}
        }
        
        CommonUtils.print2thArray(map);
        
        int cnt = 0;
        
        for(int[] query : queries) {
        	int left 	= query[1] - 1;
        	int right 	= query[3] - 1;
        	int up 		= query[0] - 1;
        	int down 	= query[2] - 1;
        	
        	System.out.println("left : " + left);
        	System.out.println("right : " + right);
        	System.out.println("up : " + up);
        	System.out.println("down : " + down);
        	
        	int R_U_VAL = _leftToRight(left, right, up, map, answer, cnt);
        	CommonUtils.print2thArray(map);
        	
        	int R_D_VAL = _UpToDown(R_U_VAL, up, down, right, map, answer, cnt);
        	CommonUtils.print2thArray(map);

        	int L_D_VAL = _rightToLeft(R_D_VAL, left, right, down, map, answer, cnt);
        	CommonUtils.print2thArray(map);
        	
        	int L_U_VAL = _downToUp(L_D_VAL, up, down, left, map, answer, cnt);
        	CommonUtils.print2thArray(map);
        	
        	cnt++;
        }
        
        return answer;
    }

	private static int _downToUp(int L_D_VAL, int up, int down, int left, int[][] map, int[] answer, int cnt) {

		System.out.println("Down => Up");
		
		int L_U_VAL = map[up][left];
		
		int min = answer[cnt];
		
		for(int i = up; i <= down - 1; i++) {
			
			if(min > map[i][left]) {
				min = map[i][left];
			}
			
			if(i == down - 1) { 
				System.out.println("i : " + i + "left : " + left);
				System.out.println("L_D_VAL : " + L_D_VAL);
				map[i][left] = L_D_VAL;
			}else {
				map[i][left] = map[i+1][left];
			}
		}
		
		answer[cnt] = min;

		System.out.println("L_U_VAL : " + L_U_VAL);
		System.out.println("=====================================");
		
		return L_U_VAL;
		
	}

	private static int _rightToLeft(int R_D_VAL, int left, int right, int down, int[][] map, int[] answer, int cnt) {
		
		System.out.println("Right => Left");
		
		int L_D_VAL = map[down][left];

		int min = answer[cnt];
		
		for(int i = left; i <= right - 1; i++) {

			if(min > map[down][i]) {
				min = map[down][i];
			}
			
			if(i == right - 1) {
				map[down][i] = R_D_VAL;
			}else {
				map[down][i] = map[down][i+1];
			}
		}
		
		answer[cnt] = min;

		System.out.println("L_D_VAL : " + L_D_VAL);
		System.out.println("=====================================");
		
		return L_D_VAL;
	}

	private static int _UpToDown(int R_U_VAL, int up, int down, int right, int[][] map, int[] answer, int cnt) {
		
		System.out.println("UP => Down");
		
		int R_D_Val = map[down][right];

		int min = answer[cnt];
		
		for(int i = down; i >= up + 1; i--) {
			
			if(min > map[i][right]) {
				min = map[i][right];
			}
			
			if(i == up+1) {
				map[i][right] = R_U_VAL;
			}else {
				map[i][right] = map[i-1][right];
			}
		}
		
 		answer[cnt] = min;

		System.out.println("R_D_Val : " + R_D_Val);
		System.out.println("=====================================");
		
		return R_D_Val;
	}

	private static int _leftToRight(int left, int right, int ceil, int[][] map, int[] answer, int cnt) {
		
		System.out.println("Left => Right");
		
		int R_U_VAL = map[ceil][right];

		int min = answer[cnt];
		
		for(int i = right; i >= left + 1; i--) {
			
			if(min > map[ceil][i]) {
				min = map[ceil][i];
			}
			map[ceil][i] = map[ceil][i-1];
		}
		
		answer[cnt] = min;
		
		System.out.println("R_U_VAL : " + R_U_VAL);
		System.out.println("=====================================");
		return R_U_VAL;
	}
}
