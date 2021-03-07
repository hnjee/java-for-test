import java.util.HashSet;
import java.util.Iterator;

class Solution {
    int makeNumber (int k, int N){
        int result = N;
        for(int i=1; i<k; i++){
            result += N * Math.pow(10, i);
        }
        return result;
    }
    public int solution(int N, int number) {
        int k = 0; //N의 개수 
        HashSet<Integer>[] dp = new HashSet[10];

        while(k<9){
            k++; 
            dp[k] = new HashSet<Integer>();
            dp[k].add(makeNumber(k, N)); 

            for(int i=1; i<k; i++){ 
                Iterator<Integer> iter_x = dp[i].iterator(); 
                while(iter_x.hasNext()){
                    int x = iter_x.next();
                    Iterator<Integer> iter_y = dp[k-i].iterator(); 
                    while(iter_y.hasNext()){
                        int y = iter_y.next();
                        dp[k].add(y + x);
                        dp[k].add(y - x);
                        dp[k].add(y * x);
                        if(x!=0) dp[k].add(y / x);
                    }
                } 
            }
            if(dp[k].contains(number)) return k;
        }
        return -1;
    }
}

