import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int length = citations.length;
        int before = citations[0];
        int volumes = length;
        if(before>=volumes) return volumes;
        
        Arrays.sort(citations);
        for(int i=1; i<length; i++){
            if(before==citations[i]) continue;
            volumes = length-i;
            if(citations[i]>=volumes) return volumes;
            before = citations[i];
        }
        if(before==0) return 0;
        return 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {31, 66}));
    }
}