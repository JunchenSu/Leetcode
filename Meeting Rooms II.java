/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
        return 0;
        
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
           @Override
           public int compare(Interval a, Interval b) {
               return a.end - b.end;
           } 
        });
        
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval temp = heap.poll();
            if (temp.end <= intervals[i].start) {
                temp.end = intervals[i].end;            
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(temp);
        }
        return heap.size();
    }
}
