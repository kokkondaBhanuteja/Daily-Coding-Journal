import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
public class DepthFirstSearch
{
	private static void dfsRecursive(int node, int n, boolean[] visited,ArrayList<ArrayList<Integer>> adj){
		System.out.print(node + ", ");
		visited[node] = true;
		for(int num: adj.get(node)){
			if(!visited[num]){
				dfsRecursive(num, n, visited,adj);
			}
		}
	}
	private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<>();
		int n = adj.size();
		boolean[] visited = new boolean[n+1];
		ArrayList<Integer> ans = new ArrayList<>();
		st.push(0);
		while(!st.isEmpty()){
			int node = st.pop();
			if(!visited[node]){
				visited[node] = true;
				ans.add(node);
				for(int num: adj.get(node)){
					if(!visited[num]) st.push(num);
				}
			}
		}
		return ans;
	}
	public static void main(String args[]){
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
        
		System.out.println("From here the Recursive Approach");
        boolean[] visited = new boolean[adj.size()+1];
		dfsRecursive(0, adj.size(), visited, adj);
		System.out.println("\nFrom here the Iterative Approach");
        ArrayList<Integer> ans = dfs(adj);
        for (int i : ans) {
            System.out.print(i + ", ");
        }
	}
}