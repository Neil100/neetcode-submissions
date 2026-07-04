class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;

        int sol = 0;
        int minVal = prices[0];

        for(int i=1; i<prices.length; i++) {
            sol = Integer.max(sol, prices[i]-minVal);

            minVal = Integer.min(minVal, prices[i]);
        }

        return sol;
    }
}
