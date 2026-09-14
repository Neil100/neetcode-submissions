class Solution {
    List<List<Integer>> adjList;
    int counter;
    boolean[] visited;
    public boolean validTree(int n, int[][] edges) {
        counter = n;
        adjList = new ArrayList<>();
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        if(!findCycle(n-1, -1)) {
            // System.out.println(counter);
            if(counter == 0)
                return true;
        }
        return false;
    }

    boolean findCycle(int node, int lastVisited) {
        if(visited[node])
            return true;
        counter--;
        visited[node] = true;
        List<Integer> list = adjList.get(node);

        for(int i=0; i<list.size(); i++) {
            if(lastVisited != list.get(i)) {
                if(findCycle(list.get(i), node)) {
                    return true;
                }
            }
        }

        return false;
    }
}
