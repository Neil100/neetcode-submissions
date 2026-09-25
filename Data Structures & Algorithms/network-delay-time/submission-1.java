class Solution {
    List<List<Integer>> list;
    int travelledNodes;
    int[] dp;
    int sol;
    public int networkDelayTime(int[][] times, int n, int k) {
        
        list = new ArrayList<>();
        dp = new int[n+1];
        travelledNodes = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        sol = Integer.MIN_VALUE;

        for(int i=0; i<n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++) {
            list.get(times[i][0]).add(times[i][1]);
            list.get(times[i][0]).add(times[i][2]);
        }

        traversePath(k, 0);

        if(travelledNodes < n) {
            return -1;
        }

        for(int i=1; i<dp.length; i++) {
            sol = Integer.max(sol, dp[i]);
        }

        return sol;
    }

    void traversePath(int s, int costToS) {
        if(dp[s]<=costToS)
            return ;
        // if(dp[s]>costToS) {
        if(dp[s] == Integer.MAX_VALUE)
            travelledNodes++;
        dp[s] = costToS;
        // sol = Integer.max(sol, costToS);
        // }

        for(int i=0; i<list.get(s).size(); i=i+2) {
            traversePath(list.get(s).get(i), costToS+list.get(s).get(i+1));
        }
    }
}
