class Solution {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        s = s.toUpperCase();
        //단어 변환 
        String[] words = s.split(" ");
        for(int i=0; i<words.length; i++){
            StringBuffer word = new StringBuffer();
            for(int j=0; j<words[i].length(); j++){
                char ch = words[i].charAt(j);
                if(j%2!=0) ch = Character.toLowerCase(ch);
                word.append(ch);
            }
            words[i] = word.toString();
        }
        //공백 문자 처리
        int sIndex = 0;
        int wordsIndex = 0;
        while(sIndex<s.length()){
            if(s.charAt(sIndex)==' ') {
                answer.append(' ');
                sIndex++;
            }
            else{
                answer.append(words[wordsIndex]);
                sIndex += words[wordsIndex].length();
                wordsIndex++;
            }
        }
        return answer.toString();        
    }
}