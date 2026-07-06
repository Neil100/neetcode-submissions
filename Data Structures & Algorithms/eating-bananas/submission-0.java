class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MAX_VALUE;
        int sol=-1;
        while(left<right) {
            int mid = (right - left) / 2 + left;
            int hoursTaken = hoursTakenToEat(piles, mid);
            if(hoursTaken <= h) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return right;
    }

    int hoursTakenToEat(int[] piles, int h) {
        int hoursTaken = 0;
        for(int i=0; i<piles.length; i++) {
            hoursTaken = hoursTaken + (piles[i]/h) + (piles[i]%h == 0 ? 0 : 1);
        }

        return hoursTaken;
    }
}
