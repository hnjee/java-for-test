class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length;
        int width = arr2[0].length;
        int[][] answer = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                for(int k=0; k<arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}