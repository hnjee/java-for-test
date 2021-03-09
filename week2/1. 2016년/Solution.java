class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int totalDays = 0;
        for(int i=1; i<a; i++) totalDays += month[i];
        totalDays += b;
        switch (totalDays%7) {
            case 0: return "THU";
            case 1: return "FRI";
            case 2: return "SAT";
            case 3: return "SUN";
            case 4: return "MON";
            case 5: return "TUE";
            default: return "WED";
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();  
        System.out.println(sol.solution(5,24));
    }
} 