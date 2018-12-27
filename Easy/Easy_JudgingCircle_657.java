package Leetcode;

import java.util.HashMap;

/*
    There is a robot starting at position (0, 0), the origin, on a 2D plane.
    Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

    The move sequence is represented by a string, and the character moves[i] represents its ith move.
    Valid moves are R (right), L (left), U (up), and D (down).
    If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

    Note: The way that the robot is "facing" is irrelevant.
    "R" will always make the robot move to the right once, "L" will always make it move left, etc.
    Also, assume that the magnitude of the robot's movement is the same for each move.

    Example 1:

    Input: "UD"
    Output: true
    Explanation: The robot moves up once, and then down once.
    All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.


    Example 2:

    Input: "LL"
    Output: false
    Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
    We return false because it is not at the origin at the end of its moves.
 */
public class Easy_JudgingCircle_657 {
    public static void main(String[] args){
        String test = "RRDD";
        boolean result = judgeCircle(test);
        System.out.println(result);
    }

    // 1: sum(moves) % 4 = 0;
    // 2: sum(U) = sum(D);
    // 3: sum(L) = sum(R); HashMap存储<K,V> pair
    // Runtime: 25 ms, faster than 10.37% of Java online submissions
    private static boolean judgeCircle(String moves){
        HashMap<Character, Integer> hm = new HashMap<>();
        for(Character c : moves.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c, 1);
            }
            else{
                hm.put(c, hm.get(c) + 1);
            }
        }
        System.out.println(hm.size());
        if(hm.size() == 1){
            return false;
        }
        else if(hm.size() == 2 && !hm.containsKey('U') && !hm.containsKey('D') && hm.get('L').equals(hm.get('R'))){
            return true;
        }
        else if(hm.size() == 2 && !hm.containsKey('L') && !hm.containsKey('R') && hm.get('U').equals(hm.get('D'))){
            return true;
        }
        else if(hm.size() == 4 && hm.get('U').equals(hm.get('D')) && hm.get('L').equals(hm.get('R'))){
            return true;
        }
        else{
            return false;
        }
    }
}
