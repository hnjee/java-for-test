import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class TotalNode implements Comparable<TotalNode>{
    String genre;
    int totalPlay;
    TotalNode(String g, int t){
        this.genre = g;
        this.totalPlay = t;
    }
    @Override
    public int compareTo(TotalNode n) {
        if(this.totalPlay > n.totalPlay) return -1;
        return 1;
    }
}

class Node implements Comparable<Node>{
    int number;
    int plays;
    Node(int n, int p){
        this.number = n;
        this.plays = p;
    }

    @Override
    public int compareTo(Node n) {
        if(this.plays > n.plays) return -1;
        if(this.plays == n.plays && this.number < n.number) return -1;
        return 1;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<Node>());   
                map.get(genres[i]).add(new Node(-1, 0)); //total Node
            }
            ArrayList<Node> list = map.get(genres[i]);
            list.get(0).plays += plays[i]; //total 갱신  
            list.add(new Node(i, plays[i])); //list에 노드 추가 
        }
        
        ArrayList<TotalNode> totalList = new ArrayList<>();  
        for(String s : map.keySet()){
            ArrayList<Node> list = map.get(s);
            totalList.add(new TotalNode(s, list.get(0).plays));
        }
        Collections.sort(totalList);


        for(TotalNode tn : totalList){
            ArrayList<Node> list = map.get(tn.genre);
            Collections.sort(list);
            for(int i=1; i<3; i++) {
                answerList.add(list.get(i).number);
                
                if(list.size()==1) break;
            }
        }

        int[] answer = new int[answerList.size()];
        int index = 0;
        for(int num : answerList) {
            answer[index] = num;
            System.out.println(answer[index]);
            index++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop", "jazz"},new int[] {500, 600, 150, 800, 2500, 6000}));
    }
}