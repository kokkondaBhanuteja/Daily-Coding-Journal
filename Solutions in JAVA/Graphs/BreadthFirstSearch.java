import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch
{
	private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
		int n = adj.size();
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int node = q.poll();
			//System.out.print(node+", " );
			ans.add(node);
			for(int num: adj.get(node)){
				if(!visited[num]){
					q.add(num);
					visited[num] = true;
				}
			}
		}
		return ans;
	}
	public static void main(String args[]){
		   // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
        
        
        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + ", ");
        }
	}
}