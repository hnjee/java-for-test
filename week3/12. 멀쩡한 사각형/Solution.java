class Solution {
    //최소공배수 구하는 함수
    private int getGcd(int w, int h){
        int min = Math.min(w, h);
        int gcd = 1;
        while(gcd<min){
            gcd++;
            if(w%gcd==0 && h%gcd==0) return gcd;
        }
        return 1;
    }
    public int solution(int w, int h) {
        return getGcd(w, h);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getGcd(2,3));   
    }
}