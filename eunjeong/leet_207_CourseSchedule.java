//  이건 완전 그래프 문제!
class Solution {    
    public boolean canFinish(int numCourses, int[][] prerequisites) {      
        //  2중 arraylist 선언하기 ()
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        //  1. 이중 리스트 초기화 & 그래프 만들기 
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        //  2. 방문배열 선언하고 makeCycle(사이클을 이루는지) 확인
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            //  사이클을 이루니까 false
            if (makeCycle(i, graph, visited)){
                return false;
            } 
        
        return true;
    }
    
    private boolean makeCycle(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1){
            return true;
        }
        if (visited[curr] == 2){
            return false;
        }
        
        //  1이 방문, 2가 방문해제
        // (이부분 true-false로 하니까 안됨... 왜그럴까ㅠ)
        visited[curr] = 1;
              
        //  리스트에서 순차적으로 꺼내며 사이클을 이루는지 확인
        //  그래프의 간선들을 체크
        for (int next : graph.get(curr)){
            if (makeCycle(next, graph, visited)){
                return true;
            }
        }
            
        //  방문 플래그 해제 
        visited[curr] = 2;
        
        return false;
    }
 
}

