/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/

// 类似扫描线，只要有发现有一个start > end的情况，就少用一个room（即前一个end，有一个room空出来）

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int start = 0, end = 0;
        while (start < intervals.length && end < intervals.length) {
            if (starts[start] >= ends[end]) {
                start++;
                end++;
            } else {
                start++;
            }      
        }
        return intervals.length - end;
    }
}
