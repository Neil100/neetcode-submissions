class Solution {
    List<List<Integer>> adjList;
    boolean[] visited;
    int counter;
    public int countComponents(int n, int[][] edges) {
        adjList = new ArrayList<>();

        visited = new boolean[n];
        counter = 0;

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int counter=0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                counter++;
                countComponents(i, -1);
            }
        }

        return counter;
    }

    void countComponents(int node, int lastNode) {
        if(visited[node]) {
            return;
        }

        visited[node] = true;

        List<Integer> list = adjList.get(node);

        for(int i=0; i<list.size(); i++) {
            if(lastNode != list.get(i))
                countComponents(list.get(i), node);
        }
    }
}
