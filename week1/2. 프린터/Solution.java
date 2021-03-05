import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
class Solution{
    public int solution(int[] priorities, int location) {
        Integer[] sorted = new Integer[priorities.length];
        for(int i=0; i<priorities.length; i++) sorted[i] = priorities[i];
        
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) que.offer(i);
    
        while(!que.isEmpty()){
            Arrays.sort(sorted, Collections.reverseOrder()); //큰게 0번 
            int max = sorted[0];
            System.out.println(max);
            int x = que.poll();
            if(priorities[x] != max) que.offer(x);
            else {
                answer++;
                if(x==location) return answer;
                sorted[0] = 0;
            } 
        }
        return answer;
    }
}