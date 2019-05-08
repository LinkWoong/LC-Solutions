package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Medium_IntervalIntersections_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B){
        if(A == null || B == null || A.length == 0 || B.length == 0){
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int start = 0, end = 0;

        while(p1 < A.length && p2 < B.length){
            start = Math.max(A[p1][0], B[p2][0]);
            end = Math.min(A[p1][1], B[p2][1]);

            if(end >= start){
                res.add(new int[]{start, end});
            }

            if(A[p1][1] == end){
                p1++;
            }
            if(B[p2][1] == end){
                p2++;
            }
        }
        return res.toArray(new int[0][]); // 注意，不要再写new int[res.size()][]了，这个更快
    }
    // 这个写错了，不能把AB合并排序，order matters
    public int[][] intervalIntersection_dead(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0){
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        int[][] result = Arrays.copyOf(A, A.length + B.length);
        System.arraycopy(B, 0, result, A.length, B.length);
        Comparator<int[]> comparator = (o1, o2) -> o1[0] > o2[0] ? 1 : o1[1] > o2[1] ? 1 : -1;
        Arrays.sort(result, comparator);

        int start = result[0][0];
        int end = result[0][1];

        for(int i = 1; i < result.length; i++){
            if(result[i][0] < end){
                start = Math.max(start, result[i][0]);
                end = Math.min(end, result[i][1]);
                res.add(new int[]{start, end});
            } else if(result[i][0] == end){
                start = result[i][0];
                res.add(new int[]{start, end});
            }
            start = result[i][0];
            end = result[i][1];
        }
        return res.toArray(new int[res.size()][]);
    }
}
