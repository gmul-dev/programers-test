package leetcode.review.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(SolutionBest.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
    }
// 7 10 14 21 23 20 21 25 27 => k가 포함된 합계
//    3  7 14 16 13 14 18 20 => 위 값과 일치하면 k가 포함되어 있다는 뜻이므로 +1
    static class SolutionBest {
        public static int subarraySum(int[] nums, int k) {
            int count = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                map.merge(k + sum, 1, (old, val) -> old + val);
                sum += nums[i];
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
            return count;
        }
    }

//    기본 아이디어는 입력받은 리스트 값을 하나씩 단계별로 더해서 sum값을 구할 때, 이 sum값이 k만큼 증가하는 순간에 합이 k값인 subarray를 구할 수 있습니다. 무슨 의미인지 풀어서 설명하겠습니다.
//    리스트 [1, 2, 1, 3]과 k = 3이 주어진다면, 단계별 sum값들은 [1, 3, 4, 7]이 됩니다. 이때, 1 -> 4인 순간과 4 -> 7인 순간을 통해서 우리는 합이 3인 subarray가 2개 있다는 것을 알 수 있습니다.
//    하지만, 실제 리스트 [1, 2, 1, 3]에서 합이 3인 subarray는 [1,2], [2,1], [3]으로 총 3개가 됩니다. 위의 계산에서 [3]을 빠뜨렸다는 것을 알 수 있습니다. 따라서 단계별 합 값이 k가 되는(위의 예제에서는 [3]) 경우를 포함하기 위해서 우리는 합계에 0을 추가하여 고려해야 합니다.
//    따라서, [0, 1, 3, 4, 7]을 순서대로 계산했을 때, 0 -> 3, 1 -> 4, 4 -> 7 총 3개의 subarray가 있다는 것을 알 수 있습니다.

    static class Solution {
        public static int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap< Integer, Integer > map = new HashMap < > ();
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
