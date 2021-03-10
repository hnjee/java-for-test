import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    void dfs(String start, String route, List<String> routeList, boolean[] visited, String[][] tickets){
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i]=true;
                route += ","+ tickets[i][1];
                dfs(tickets[i][1], route, routeList, visited, tickets);
                //다시 visited와 route 원상복귀 (백트래킹)
                visited[i]=false;
                route = route.substring(0, route.length()-4);
            }
        }
        //방문할 수 있는 티켓이 없거나, 모두 방문한 경우 for문 탈출 
        //그 중 모두 방문한 경우의 루트만 routeList에 추가 
        int cnt = route.split(",").length; 
        if(cnt==tickets.length+1) routeList.add(route); 
    }
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        List<String> routeList = new LinkedList<>();  

        //티켓을 모두 사용하는 루트들 모으는 dfs수행  
        dfs("ICN", "ICN", routeList, visited, tickets); 

        //루트들을 알파벳순으로 정렬하고 알파벳 순서 가장 앞서는 루트 리턴
        Collections.sort(routeList);
        return routeList.get(0).split(",");
    }
}