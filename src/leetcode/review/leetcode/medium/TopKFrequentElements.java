package leetcode.review.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    static class Solution {
        public static int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
            for(int n : map.keySet()) {
                pq.add(n);
                if(pq.size() > k) {
                    pq.poll();
                }
            }

            int[] res = new int[k];
            for(int i = 0; i < k; i++) {
                res[i] = pq.poll();
            }
            return res;
        }
    }
}
