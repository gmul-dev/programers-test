package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        System.out.println(SolutionPriorityQueue.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
    }

    static class Solution {
        public static int[][] reconstructQueue(int[][] people) {
            if(people == null || people.length==0 || people[0].length==0) return new int[0][0];
            int n = people.length;
            sort(people, 0, n-1);
            List<int[]> lst = new ArrayList<>();
            for(int[] p : people){
                lst.add(p[1], p);
            }
            return lst.toArray(new int[people.length][]);
        }

        private static void sort(int[][] people, int l, int h){
            if(l>=h) return;
            int j = partition(people, l, h);
            sort(people, l, j-1);
            sort(people, j+1, h);
        }

        private static int partition(int[][] people, int l, int h){
            int[] lNum = people[l];
            while(l<h){
                while(l<h && isLT(people[h], lNum)) h--;
                people[l] = people[h];
                while(l<h && !isLT(people[l], lNum)) l++;
                people[h] = people[l];
            }
            people[l] = lNum;
            return l;
        }

        private static boolean isLT(int[] a, int[] b){
            return a[0]<b[0] || (a[0]==b[0] && a[1]>b[1]);
        }
    }

    static class SolutionPriorityQueue {
        public static int[][] reconstructQueue(int[][] people) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)->p1[0] == p2[0]? p1[1]-p2[1] : p2[0]-p1[0]);
            for(int[] p : people) {
                pq.add(p);
            }

            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                list.add(p[1], p);
            }

            return list.toArray(new int[people.length][]);
        }
    }
}
