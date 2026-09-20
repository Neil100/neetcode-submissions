class Solution {
    // List<List<Integer>> adjList;
    // public int[] findRedundantConnection(int[][] edges) {
        
    //     adjList = new ArrayList<>();

    //     for(int i=0; i<=edges.length; i++) {
    //         adjList.add(new ArrayList<>());
    //     }

    //     for(int i=0; i<edges.length; i++) {
    //         int a = edges[i][0];
    //         int b = edges[i][1];
    //         Set<Integer> isPassed = new HashSet<Integer>();
    //         if(areConnected(a, b, isPassed)) {
    //             return new int[]{a, b};
    //         }
    //         adjList.get(a).add(b);
    //         adjList.get(b).add(a);
    //     }
    //     // System.out.println(adjList);
    //     return new int[2];
    // }

    // boolean areConnected(int a, int b, Set<Integer> isPassed) {
    //     if(a==b)
    //         return true;
    //     List<Integer> list = adjList.get(a);
    //     isPassed.add(a);
    //     for(int i=0; i<list.size(); i++) {
    //         if(!isPassed.contains(list.get(i)) && areConnected(list.get(i), b, isPassed)) {
    //             return true;
    //         }
    //     }
    //     isPassed.remove(a);
    //     return false;
    // }

    public int[] findRedundantConnection(int[][] edges) {

        int[] nodes = new int[edges.length+1];

        for(int i=0; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            int r1 = findRoot(a, nodes);
            int r2 = findRoot(b, nodes);

            if(r1==r2) {
                return new int[]{a, b};
            }

            if(r1<r2) {
                nodes[r1]--;
                nodes[r2] = r1;
            } else {
                nodes[r2]--;
                nodes[r1] = r2;
            }
        }

        return new int[2];
    }

    int findRoot(int a, int[] nodes) {
        while(nodes[a]>0) {
            a = nodes[a];
        }

        return a;
    }
}
