import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private void bfs(ArrayList<Integer>[] graph, int[] distance){
        Queue<Integer> que = new LinkedList<>(); 
        que.offer(1);
        distance[1] = 1;
        while(!que.isEmpty()){
            int x = que.poll();
            ArrayList<Integer> list = graph[x];
            for(int y : list){
                if(distance[y]==0){
                    que.offer(y);
                    distance[y] = distance[x]+1;
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 1;
        int[] distance = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        //그래프 만들기 
        for(int i=1; i<n+1; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        //노드 별 거리 구하기 
        bfs(graph, distance);

        //가장 멀리 떨어진 노드 갯수 구하기 
        Arrays.sort(distance);
        int max = distance[n];
        for(int i=n-1; i>=0; i--){
            if(distance[i]==max) answer++;
            else break;
        }
        return answer;
    }
}