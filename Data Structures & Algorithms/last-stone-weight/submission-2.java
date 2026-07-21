class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int stone: stones) {
            pq.offer(stone);
        }

        while(pq.size()>1) {
            int largest = pq.poll();
            int secLargest = pq.poll();

            if(largest!=secLargest) {
                pq.offer(largest-secLargest);
            }
        }

        return pq.size()==0 ? 0 : pq.poll();
    }
}
