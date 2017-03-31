/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {//Collections sort(List<T>,Comparator<? super T>)
            @Override
            public int compare(Interval obj1, Interval obj2) {
                return obj1.start - obj2.start;//sort the start 
            }
        });
        
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for(Interval current : intervals) {
            if (prev == null || current.start > prev.end) {
                res.add(current);
                prev = current;
            } else {
                //modify the element already in the list
                prev.end = Math.max(prev.end, current.end);
            }
        }
        return res;
    }
}
