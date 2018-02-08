Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


// DFS, 对于undirected graph, use visited boolean to minimize duplicate search

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> groups = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[n]; // default is false  
        int res = 0;
        for (int i = 0; i < n; i++) {
            groups.add(new ArrayList<Integer>()); 
        }
        for (int[] edge : edges) {
            groups.get(edge[0]).add(edge[1]);
            groups.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(visited, i, groups);
            }
        }
        return res;
    }
    
    private void dfs(boolean[] visited, int index, List<List<Integer>> groups) {
        visited[index] = true;
        for (Integer i : groups.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, groups);
            }
        }
    }
}


