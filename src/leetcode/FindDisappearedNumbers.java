package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(Solution2.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    static class Solution1 {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                int newIndex = Math.abs(nums[i]) - 1;
                if (nums[newIndex] > 0) {
                    nums[newIndex] *= -1;
                }
            }

            for (int i = 1; i <= nums.length; i++) {
                if (nums[i - 1] > 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            //Simple solution based on observation: nums[i] should be at position nums[i]-1
            for (int i = 0 ; i < nums.length; i++){
                do {
                    int k = nums[i] -1 ;
                    if ( nums[i] != nums[k] ){
                        int t = nums[i];
                        nums[i] = nums[k];
                        nums[k] = t ;
                    } else break;
                } while(true) ;
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0 ; i < nums.length; i++){
                if (nums[i] != (i+1)) res.add(i+1);
            }
            return res;
        }
    }

    static class Solution {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int[] order = new int[nums.length + 1];
            for (int i = 0 ; i < nums.length; i++) {
                order[nums[i]]++;
            }
            for (int i = 1 ; i < order.length; i++) {
                if (order[i] == 0) {
                    list.add(i);
                }
            }
            return list;
        }
    }
}
