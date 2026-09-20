class Solution {
    List<List<Integer>> adjList;
    public int[] findRedundantConnection(int[][] edges) {
        
        adjList = new ArrayList<>();

        for(int i=0; i<=edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            Set<Integer> isPassed = new HashSet<Integer>();
            if(areConnected(a, b, isPassed)) {
                return new int[]{a, b};
            }
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        // System.out.println(adjList);
        return new int[2];
    }

    boolean areConnected(int a, int b, Set<Integer> isPassed) {
        if(a==b)
            return true;
        List<Integer> list = adjList.get(a);
        isPassed.add(a);
        for(int i=0; i<list.size(); i++) {
            if(!isPassed.contains(list.get(i)) && areConnected(list.get(i), b, isPassed)) {
                return true;
            }
        }
        isPassed.remove(a);
        return false;
    }
}
