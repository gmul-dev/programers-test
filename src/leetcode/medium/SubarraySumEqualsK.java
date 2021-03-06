package leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] params = new int[]{2,0,2,1,1,0};        
        System.out.println(Solution.subarraySum(params, 4));
    }

    static class Solution {
        public static int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i-1] + nums[i-1];
            }
            int res = 0;
            for (int i = 0; i < preSum.length; i++) {
                if (map.containsKey(preSum[i] - k)) {
                    res += map.get(preSum[i] - k);
                } 
                if (map.containsKey(preSum[i])) {
                    map.put(preSum[i], map.get(preSum[i]) + 1);
                } else {
                    map.put(preSum[i], 1);
                }
            }
            return res;      
        }
    }
    
    static class Solution2 {
        public static int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap < Integer, Integer > map = new HashMap < > ();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;        
        }
    }
}
