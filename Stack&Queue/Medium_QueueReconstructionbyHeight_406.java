package Leetcode;

import java.util.*;

/*
    Suppose you have a random list of people standing in a queue.
    Each person is described by a pair of integers (h, k),
    where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
    Write an algorithm to reconstruct the queue.

    Note:
    The number of people is less than 1,100.


    Example

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Medium_QueueReconstructionbyHeight_406 {

    // 思路：先按照people[0]降序，people[1]升序排序。首先满足height最大的元素，其次再考虑k
    // 对于最大的元素，肯定是按照k值放置即[7,0]放array的index=0，[7,1]放index=1，因为比[7,0]小的排不到前面去
    // 对于剩下的元素，按照k值插入到[[7,0], [7,1]]中：例如[[7,0], [6,1], [7,1]]
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people, comparator);
        List<int[]> res = new ArrayList<>();
        for(int[] num: people){
            res.add(num[1], num);
        }

        int[][] return_array = new int[people.length][];
        for(int i = 0; i < people.length; i++){
            return_array[i] = res.get(i);
        }
        return return_array;
    }
}
