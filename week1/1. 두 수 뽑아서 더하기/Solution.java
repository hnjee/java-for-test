import java.util.Arrays;
import java.util.HashSet;

public class Solution{
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = new int[hashMap.size()];
        int index = 0;
        for(int key : hashMap.keySet()) answer[index++] = key;
        Arrays.sort(answer);

        return answer;
    }
}