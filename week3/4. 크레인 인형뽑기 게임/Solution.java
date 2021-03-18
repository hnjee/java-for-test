import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int x = board.length;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves){
            m--; //배열 인덱스에 맞추기 
            for(int i=0; i<x; i++){
                int newNode = board[i][m];
                if(newNode!=0) {
                    if(!stack.isEmpty()) {
                        int top = stack.peek(); 
                        if(newNode==top){
                            stack.pop();  
                            answer+=2;   
                            board[i][m]=0; 
                            break;
                        } 

                    }
                    stack.push(newNode);
                    board[i][m]=0;
                    break;
                } 
            }
        }
        return answer;
    }
}