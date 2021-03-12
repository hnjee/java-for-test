import java.util.HashMap;

class Solution {
    public String solution(String[] seoul) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<seoul.length; i++){
            hashMap.put(seoul[i], i);
        }
        return "김서방은 "+hashMap.get("Kim")+"에 있다";
    }
}