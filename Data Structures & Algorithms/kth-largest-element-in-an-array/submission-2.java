class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);

        // for(int num: nums) {
        //     pq.offer(num);

        //     while(pq.size()>k) {
        //         pq.poll();
        //     }
        // }

        // return pq.poll();

        int left = -1000, right = 1000;
        while(left<=right) {
            int mid = (right - left)/2 + left;

            int counter = 0;
            int equalCount = 0;
            for(int num: nums) {
                if(num>mid) {
                    counter++;
                } else if(num==mid) {
                    equalCount++;
                }
            }

            if(k>counter && k<=counter+equalCount)
                return mid;
            
            if(counter>k-1) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return 0;
    }
}
