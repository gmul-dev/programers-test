package leetcode.review.leetcode.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(Solution.maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    static class Solution {
        public static int maxArea(int[] height) {
            int l = 0;
            int r = height.length-1;
            int max = 0;
            while (l < r) {
                if(height[r] > height[l]) {
                    max = Math.max(max, r-l * height[l]);
                    l++;
                } else {
                    max = Math.max(max, r-l * height[r]);
                    r--;
                }
            }
            return max;
        }
    }
}
