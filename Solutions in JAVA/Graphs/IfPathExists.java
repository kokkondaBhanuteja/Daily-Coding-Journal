import java.util.ArrayList;
import java.util.Stack;
public class IfPathExists
{
	private static boolean validPath(int n, int[][] edges, int source, int destination) {   
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());

        for(int[] edge: edges){
            int  u= edge[0], v= edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        st.push(source);
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                visited[node] = true;
                if(node == destination)return true;
                for(int num: graph.get(node)){
                    if(!visited[num]){
                        st.push(num);
                    }
                }
            }
        }
        return false;
    }

	public static void main(String args[]){
        int n = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {3, 5},
            {5, 4},
            {4, 3}
        };
        int source = 0;
        int destination = 5;

        boolean result = validPath(n, edges, source, destination);
        System.out.println("Path exists: " + result);
	}
}