package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        System.out.println(Solution.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
    }

    static class Solution {
        public static int[][] reconstructQueue(int[][] people) {
//            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] == p2[0]? p1[1] - p2[1] : p2[0] - p1[0]);
//
//            List<int[]> list = new ArrayList<>();
//            while (!pq.isEmpty()) {
//                int[] p = pq.poll();
//                list.add(p[1], p);
//            }
//
//            return list.toArray(new int[people.length][]);

            Arrays.sort(people, (a, b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);

            List<int[]> res = new ArrayList<>();

            for (int[] i : people) {
                res.add(i[1], i);
            }

            return res.toArray(new int[people.length][2]);
        }
    }
}
