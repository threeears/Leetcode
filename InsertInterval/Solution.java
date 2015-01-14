// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].



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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
       
        List<Interval> result = new ArrayList<Interval>();
         if(n==0)
        {
            result.add(newInterval);
            return result;
        }
        
        for(int i = 0;i<n;i++){
            if(newInterval.end < intervals.get(i).start){
                // new is ahead of current interval, add new interval and left intervals and return 
                result.add(newInterval);
                for(int k=i;k<n;k++){
                    result.add(intervals.get(k));
                }
                return result;
            }
            else if(newInterval.start > intervals.get(i).end){
                // new interval is behind than current interval, compare with next round
                result.add(intervals.get(i));
                continue;
            }
            else{
                if(newInterval.start>=intervals.get(i).start && newInterval.end<=intervals.get(i).end){
                    // new interval within in the current interval, add current interval and the rest
                    // return the result
                    for(int k=i;k<n;k++){
                        result.add(intervals.get(k));
                     }
                    return result;
                }
                else {
                    int min=Math.min(intervals.get(i).start,newInterval.start);
                    int max=Math.max(intervals.get(i).end, newInterval.end);
                    newInterval.start = min;
                    newInterval.end = max;
                }
            }
        }     
        result.add(newInterval);
        return result;
    }
// more clean code from ninechapter
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        ArrayList<Interval> results = new ArrayList<Interval>();
        int insertPos = 0;

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                results.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {
                results.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        results.add(insertPos, newInterval);

        return results;
    }
}