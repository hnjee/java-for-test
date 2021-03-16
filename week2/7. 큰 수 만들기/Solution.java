class Solution {    
    public String solution(String number, int k) {
        String answer = "";
        int target = number.length()-k;
        int start = 0;
        while(k>0){
            int max = start;
            for(int i=start; i<=start+k; i++){
                if(number.charAt(i)>number.charAt(max)) max = i;
            }
            answer += number.charAt(max);
            if(answer.length()==target) return answer;
            k -= (max - start); 
            start = max+1;
        }
        answer += number.substring(start, number.length());
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("54321", 4));
    }
}