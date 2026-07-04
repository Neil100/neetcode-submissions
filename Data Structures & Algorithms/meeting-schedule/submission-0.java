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
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort( (a, b) -> a.start >= b.start ? 1 : -1);

        if (intervals.size() == 0)
            return true;

        Interval checkInterval = intervals.get(0);

        for(int i=1; i<intervals.size(); i++) {
            if (intervalsOverlap(checkInterval, intervals.get(i)))
                return false;

            if (checkInterval.end <= intervals.get(i).start)
                checkInterval = intervals.get(i);
        }
        return true;
    }

    private boolean intervalsOverlap(Interval firstInterval, Interval secondInterval) {

        if (firstInterval.start < secondInterval.start && firstInterval.end <= secondInterval.start)
            return false;
        if (secondInterval.start < firstInterval.start && secondInterval.end <= firstInterval.start)
            return false;

        return true;
    }
}
