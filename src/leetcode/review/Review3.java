package leetcode.review;

public class Review3 {

    public static void main(String[] args) {
        System.out.println(SolutionBest.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    static class SolutionBest {

        public static int maxArea(int[] height) {
            return helper(height, 0, height.length - 1, 0);
        }

        public static int helper(int[] height, int start, int end, int max) {
            int currCap = Math.min(height[start], height[end]) * (end - start);
            if(currCap > max) {
                max = currCap;
            }

            if(start - end == 1)
                return max;

            boolean valueChange = false;

            if(height[start] > height[end]) {
                for(int i = end - 1; i > start; i--) {
                    if(height[end] < height[i]) {
                        end = i;
                        valueChange = true;
                        break;
                    }
                }
            } else {
                for(int i = start + 1; i < end; i++) {
                    if(height[start] < height[i]) {
                        start = i;
                        valueChange = true;
                        break;
                    }
                }
            }

            if(valueChange) {
                return helper(height, start, end, max);
            }

            return max;
        }
    }
}
