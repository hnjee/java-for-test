class Solution {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        int cnt = 0;
        s = s.toUpperCase();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' ') cnt = 0;
            else {
                if(cnt%2!=0) ch = Character.toLowerCase(ch);
                cnt++; 
            }
            answer.append(ch);
        }   
        return answer.toString();
    }
}