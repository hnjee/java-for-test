class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 1;
        int width = yellow;
        int tempBrown = 0;
        while(width>=height){
            tempBrown = (width+height)*2+4;
            if(tempBrown==brown) break;
            while(true){
                height++;
                if(yellow%height==0) {
                    width = yellow/height;
                    break;
                }
            } 
        }
        System.out.println(width+2);
        System.out.println(height+2);
        return new int[] {width+2, height+2};
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8,1));
    }
}