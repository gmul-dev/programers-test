package leetcode.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(MySolution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    static class MySolution {
        public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int result = 0;

            while (left < right) {
                int multi = Math.min(height[left], height[right]) * (right - left);
                if(result < multi) {
                    result = multi;
                }
                //result = Math.max(result, Math.min(height[left], height[right]) * (right - left));

                if(height[left] >= height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return result;
        }
    }

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

