package leetcode.review;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public static void main(String[] args) {
        System.out.println(Solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    static class Solution {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            int i = 0;
            while (i < nums.length) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    i++;
                }
            }

            for(int j = 1; j <= nums.length; j++) {
                if(j != nums[j-1]) {
                    result.add(j);
                }
            }

            return result;
        }
    }
}
