package leetcode.medium;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(SolutionPriorityQueue.topKFrequent(new int[]{1,1,1,1,1,3,3,3,2,2}, 2));
    }
//
//    class Solution {
//        public int[] topKFrequent(int[] nums, int k) {
//            Map<Integer, Integer> map = new HashMap<>();
//
////            for(int i = 0; i < nums.length; i++) {
////                if(map.containsKey(nums[i])) {
////                    map.put(nums[i], map.get(nums[i]));
////                } else {
////                    map.put(nums[i], 1);
////                }
////            }
//            for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
//
//
//        }
//    }

    static class SolutionPriorityQueue {
        public static int[] topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            PriorityQueue<IntegerPair> pq = new PriorityQueue();
            int num = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    count++;
                } else {
                    pq.add(new IntegerPair(num, count));
                    num = nums[i];
                    count = 1;
                }
            }

            pq.add(new IntegerPair(num, count));

            int[] ans = new int[k];
            for (int i = 0; i < k ; i++) {
                IntegerPair pair = pq.poll();
                ans[i] = pair.getNum();
            }
            return ans;
        }
    }


    static class IntegerPair implements Comparable<IntegerPair> {
        Integer num;
        Integer count;

        public IntegerPair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(IntegerPair o) {
            return o.getCount() - this.getCount();
        }

        Integer getNum() {
            return num;
        }

        Integer getCount() {
            return count;
        }
    }

    class SolutionBest {
        public int[] topKFrequent(int[] nums, int k) {

            int n = nums.length;
            int[] keys = new int[n];
            int[] values = new int[n];
            for (int num : nums) {
                int hash = hash(num, n);
                while (keys[hash] != num && values[hash] > 0) {
                    hash++;
                }
                keys[hash] = num;
                values[hash]++;
            }
            List<Integer>[] sortedByFreq = (List<Integer>[]) new List[nums.length + 1];
            for (int i = 0; i < n; i++) {
                if (values[i] > 0) {
                    if (sortedByFreq[values[i]] == null) {
                        sortedByFreq[values[i]] = new ArrayList<>();
                    }
                    sortedByFreq[values[i]].add(keys[i]);
                }
            }
            int[] topKFrequent = new int[k];
            for (int i = sortedByFreq.length - 1; i >= 0 && k > 0; i--) {
                if (sortedByFreq[i] != null) {
                    for (int num : sortedByFreq[i]) {
                        topKFrequent[--k] = num;
                        if (k == 0) {
                            return topKFrequent;
                        }
                    }
                }
            }
            return topKFrequent;
        }

        private int hash(int key, int buckets) {
            return (key & 0x7fffffff) % buckets;
        }
    }
}
