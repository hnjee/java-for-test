class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m]; //최단거리의 개수 저장하는 dp 
        dp[0][0] = 1;
        //물 웅덩이 길 (높이, 너비 순)
        for(int i=0; i<puddles.length; i++) dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        //최단거리 개수 = 왼쪽 + 위 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j]!=0) continue;
                int up = i>0 ? dp[i-1][j] : 0;
                int left = j>0 ? dp[i][j-1] : 0;
                dp[i][j] = (up+left)%1000000007; // dp int로 선언하고 저장할때마다 나머지처리   
                if(up==-1) dp[i][j]++;
                if(left==-1) dp[i][j]++;
            }
        }
        return dp[n-1][m-1];
    }
}