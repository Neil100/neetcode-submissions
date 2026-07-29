class Solution {
    public int leastInterval(char[] tasks, int n) {
        // _ _ _ _ _ _ n = 3
        int[] counts = new int[26];

        for(int i=0; i<tasks.length; i++) {
            counts[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        Queue<int[]> queue = new LinkedList<>();

        for(int count : counts) {
            if(count!=0) {
                pq.offer(count);
            }
        }
        int sol = 0;
        int timeCounter = 0;

        while(pq.size()!=0 || queue.size()!=0) {
            if(!pq.isEmpty()) {
                int max = pq.poll();
                max--;
                if(max!=0) {
                    queue.add(new int[]{max, timeCounter+n});
                }
            }

            while(!queue.isEmpty()) {
                int[] element = queue.peek();
                if(timeCounter >= element[1]) {
                    queue.poll();
                    pq.offer(element[0]);
                } else {
                    break;
                }
            }
            timeCounter++;
        }

        return timeCounter;
    }
}
