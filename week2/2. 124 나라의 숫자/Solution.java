class Solution {
    public String solution(int n) {
        String answer = "";
        String[] nums = {"4", "1", "2"};
        int x = n;
        while(x>0){
            int remain = x%3;
            answer = nums[remain] + answer;
            x /= 3;
            if(remain==0) x--;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3));
    }
}
