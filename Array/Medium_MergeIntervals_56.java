package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Medium_MergeIntervals_56 {
    // 思路：先按照interval[0]左区间排序，再比较end大小。
    // 对于end比下一个interval左区间要大的，说明相交，更新end为interval[1]
    // 否则不相交，更新start和end为目前区间，检查下一个
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        Comparator<int[]> comparator = (o1, o2) -> o1[0] - o2[0];
        Arrays.sort(intervals, comparator);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval: intervals){
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            } else{
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
