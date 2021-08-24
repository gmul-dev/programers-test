package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    public static void main(String[] args) {
        System.out.println(SolutionBest.canReach(new int[]{3,0,2,1,2},2));
    }

    static class SolutionBest {
        public static boolean canReach(int[] arr, int start) {
            if (start < 0 || start >= arr.length) return false;
            if (arr[start] == 0) return true;
            if (arr[start] < 0) return false;
            arr[start] = -arr[start]; // visited
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
    }

    class SolutionDFS {
        public boolean canReach(int[] arr, int start) {
            return doDfs(arr, start, new boolean[arr.length]);
        }
        private boolean doDfs(int[] arr, int start, boolean[] visited) {
            if (start < 0 || start >= arr.length) return false;
            if (arr[start] == 0) return true;
            if (visited[start] == true) return false;
            visited[start] = true;
            return doDfs(arr, start - arr[start], visited) || doDfs(arr, start + arr[start], visited);
        }
    }

    class SolutionQueue {
        public boolean canReach(int[] arr, int start) {
            boolean[] jumped = new boolean[arr.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()) {
                int currIndex = queue.poll();
                jumped[currIndex] = true;
                if (arr[currIndex] == 0) {
                    return true;
                }
                int nextRIndex = arr[currIndex] + currIndex;
                if (nextRIndex >= 0 && nextRIndex < arr.length && !jumped[nextRIndex]) {
                    queue.offer(nextRIndex);
                }
                int nextLIndex = currIndex - arr[currIndex];
                if (nextLIndex >= 0 && nextLIndex < arr.length && !jumped[nextLIndex]) {
                    queue.offer(nextLIndex);
                }
            }

            return false;
        }
    }
}
