import java.util.HashSet;

class Solution {
    //소수인지 아닌지 판별하는 메소드 
    private boolean primeNumberCheck(int x){
        if(x<2) return false;
        for(int i=2; i*i<=x; i++){
            if(x%i==0) return false;
        }
        return true;
    }
    private void dfs(int index, String stringNumber, String[] arr, boolean[] visited, HashSet<Integer> primeNumberSet){
        visited[index] = true;
        stringNumber += arr[index];
        for(int i=0; i<arr.length; i++){
            if(visited[i]==true) continue;
            dfs(i, stringNumber, arr, visited, primeNumberSet);
        }
        int number = Integer.parseInt(stringNumber);
        if(!primeNumberSet.contains(number) && primeNumberCheck(number)) primeNumberSet.add(number);
        //백트레킹 
        visited[index] = false;
        stringNumber = stringNumber.substring(0, stringNumber.length()-1);    
    }
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        boolean[] visited = new boolean[arr.length];
        HashSet<Integer> primeNumberSet = new HashSet<>();
        //numbers로 만들 수 있는 모든 숫자 조합 -> dfs + 백트레킹   
        for(int i=0; i<arr.length; i++){       
            dfs(i, "", arr, visited, primeNumberSet);
        }
        return primeNumberSet.size();
    }
}