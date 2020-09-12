package leetcode.review;

public class Review3 {
    static class SolutionBest {

        public int maxArea(int[] height) {
            return helper(height, 0, height.length - 1, 0);
        }

        public int helper(int[] height, int start, int end, int max) {
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
