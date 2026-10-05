class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> traversedPoints = new HashSet<Integer>();

        Queue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        int n = points.length;
        // create adj list
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int distance = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);

                adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{distance, j});
                adjList.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{distance, i});
            }
        }
        

        int nodeCount = 1;
        pQ.offer(new int[]{0, 0});
        // traversedPoints.add(0);
        int sol = 0;
        while(traversedPoints.size()<n) {
            int[] node = pQ.poll();
            if(traversedPoints.contains(node[1]))
                continue;
            traversedPoints.add(node[1]);
            List<int[]> neighbours = adjList.get(node[1]);
            sol = sol + node[0];
            for(int i=0; neighbours!=null && i<neighbours.size(); i++) {
                int[] oneNode = neighbours.get(i);
                if(!traversedPoints.contains(oneNode[1])) {
                    pQ.offer(new int[]{oneNode[0], oneNode[1]});
                }
            }
        }

        return sol;
    }
}
