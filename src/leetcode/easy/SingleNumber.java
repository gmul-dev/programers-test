package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(Solution.singleNumber(new int[]{4,1,2,1,2}));
    }

    static class Solution {
        public static int singleNumber(int[] nums) {
            int exclusive = 0;
            for(int num : nums) {
                exclusive = exclusive^num;
            }
            return exclusive;
        }
    }

    static class SolutionMathFormula {

        // 2∗(a+b+c)−(a+a+b+b+c)=c

        public int singleNumber(int[] nums) {
            int sumOfSet = 0, sumOfNums = 0;
            Set<Integer> set = new HashSet();

            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                    sumOfSet += num;
                }
                sumOfNums += num;
            }
            return 2 * sumOfSet - sumOfNums;
        }
    }
}