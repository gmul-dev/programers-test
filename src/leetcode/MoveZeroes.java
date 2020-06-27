package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution.moveZeroes(new int[]{0,1,0,3,12});
    }

    // 0이 아닌 요소를 swap
    static class Solution {
        public static void moveZeroes(int[] nums) {
            if(nums == null || nums.length ==0) return;
            int start=0;
            for(int i=0;i<nums.length;i++) {
                if (nums[i] != 0) {
                    int temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;
                    start++;
                }
            }
        }
    }

    static class Solution1 {
        public void moveZeroes(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) list.add(nums[i]);
                nums[i] = 0;
            }
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
        }
    }

    static class Solution2 {
        public void moveZeroes(int[] nums) {
            int cnt = 0;
            int n = nums.length;
            for(int i = 0; i < n; i++){
                if(nums[i] == 0){
                    cnt++;
                }
                else{
                    nums[i - cnt] = nums[i];
                }
            }

            for(int i = n-1; i > n-1-cnt; i--){
                nums[i] = 0;
            }
        }
    }
}
