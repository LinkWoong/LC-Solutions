package Leetcode;
/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
    You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
    Note:

    If there exists a solution, it is guaranteed to be unique.
    Both input arrays are non-empty and have the same length.
    Each element in the input arrays is a non-negative integer.
    Example 1:

    Input:
    gas  = [1,2,3,4,5]
    cost = [3,4,5,1,2]

    Output: 3

    Explanation:
    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
    Travel to station 4. Your tank = 4 - 1 + 5 = 8
    Travel to station 0. Your tank = 8 - 2 + 1 = 7
    Travel to station 1. Your tank = 7 - 3 + 2 = 6
    Travel to station 2. Your tank = 6 - 4 + 3 = 5
    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
    Therefore, return 3 as the starting index.
    Example 2:

    Input:
    gas  = [2,3,4]
    cost = [3,4,3]

    Output: -1

    Explanation:
    You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
    Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
    Travel to station 0. Your tank = 4 - 3 + 2 = 3
    Travel to station 1. Your tank = 3 - 3 + 3 = 3
    You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
    Therefore, you can't travel around the circuit once no matter where you start.
 */
public class Medium_GasStation_134 {
    // 思路：考观察和intuitive。我用的brute force，直接index从0走起，到gas.length - 1结束
    // total计算总共油箱内的油，index计算相对坐标，可以计算坐标超出gas.length - 1的部分
    // res从0开始，对每个gas[index]进行检查，如果total + gas[index] < cost[index]说明油箱剩的和加油站的gas不够，直接跳出本次循环进到res++
    // 如果够，total就加gas[index] - cost[index]部分。全部元素遍历结束后如果total >= 0，说明可以完成一次，返回res
    // 好在解是unique的，返回第一次出现total >= 0的index即可
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0){
            return 0;
        }
        // brute force
        int res = 0;
        while(res < gas.length){
            int total = 0;
            int index;
            for(int i = res; i < res + gas.length; i++){
                if(i > gas.length - 1){
                    index = i - gas.length;
                } else {
                    index = i;
                }
                if(total + gas[index] < cost[index]){
                    total = -1;
                    break;
                } else {
                    total += gas[index];
                    total -= cost[index];
                }
            }
            if(total >= 0){
                // System.out.println("Returning");
                return res;
            } else{
                res++;
            }
        }
        return -1;
    }
}
