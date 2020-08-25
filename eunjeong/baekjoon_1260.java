import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class baekjoon_1260 {
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		V = input.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>(N+1);
		
		//	초기화
		for(int i=0; i< N+1 ; i++ ) {
			graph.add(new ArrayList<Integer>());
		}
	
		//	간선 업데이트 
		for(int i=0; i<M; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		for(int i=0; i< N+1 ; i++ ) {
			Collections.sort(graph.get(i));
		}
		
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
		
		input.close();
	}
	
	public static void dfs(int start) {
		if(visited[start]) {
			return;
		}
		
		visited[start] = true;
		System.out.print(start + " ");
		for(int i=0; i < graph.get(start).size(); i++) {
			int x = graph.get(start).get(i);
			if(!visited[x]) {
				dfs(x);
			}
		}
		
	}
	
	
	
	public static void bfs(int start) {		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for(int y=0; y< graph.get(x).size(); y++) {
				int target = graph.get(x).get(y);
				//	아직 방문하지 않았으면
				if(!visited[target]) {
					visited[target] = true;
					queue.add(target);
				}
			}
		}
		
		
	} 
	

}
