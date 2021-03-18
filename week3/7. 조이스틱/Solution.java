class Solution {
    
    public int solution(String name) {
        int answer = 0;
        int forward = 0;
        int backward = 0;
        int cntA = 0;

        //1. 조이스틱 상하 이동 최소 값  
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            if(ch!='A') answer += (ch-'A')>('Z'-ch + 1)? ('Z'-ch + 1) : (ch-'A');
        }
        //2. 조이스틱 좌우 이동 최소 값 
        //1. 앞에서 뒤로 이동하는 경우
         for(int i=1; i<name.length(); i++){
            if(name.charAt(i)=='A') cntA++;
            else{
                forward+=cntA+1;
                cntA=0;
            };
        }
        //2. 뒤에서 앞으로 이동하는 경우 
        for(int i=name.length()-1; i>0; i--){
            if(name.charAt(i)=='A') cntA++;
            else{
                backward+=cntA+1;
                cntA=0;
            };
        }
        //3. 앞으로 가다가 뒤로 이동하는 경우

        //4. 뒤로 가다가 앞으로 이동하는 경우 
        
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("AABAAAAAAABBB"));
    }
}