class KthLargest {

    PriorityQueue<Integer> pQ;
    int kValue;
    public KthLargest(int k, int[] nums) {
        pQ = new PriorityQueue<>((a,b) -> a-b);
        kValue = k;
        for(int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        int num = val;
        if(pQ.size()==kValue) {
                if(num>=pQ.peek()) {
                    pQ.poll();
                    pQ.offer(num);
                }
        } else {
                pQ.offer(num);
        }

        return pQ.peek();
    }
}
