/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int sol = 0;
        int startTimes[] = new int[intervals.size()], endTimes[] = new int[intervals.size()];

        for (int i=0; i<intervals.size(); i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startIndex = 0, endIndex = 0;
        int roomRequired = 0;

        while (startIndex < intervals.size() && endIndex < intervals.size()) {
            if(startTimes[startIndex] < endTimes[endIndex]) {
                roomRequired++;
                sol = Integer.max(roomRequired, sol);

                startIndex++;
            } else {
                roomRequired--;
                endIndex++;
            }
        }
        return sol;
    }
}
