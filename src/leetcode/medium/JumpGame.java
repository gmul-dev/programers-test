package leetcode.medium;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(SolutionBackTracking.canJump(new int[]{3,2,1,0,4}));
    }

    //Time complexity : O(2^n)
    static class SolutionBackTracking {
        public static boolean canJumpFromPosition(int position, int[] nums) {
            if (position == nums.length - 1) {
                return true;
            }

            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            //  +1 씩 도약
            //for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            // 가능한 멀리 도약
            for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }

    }

    //Time complexity : O(n)
    static class SolutionGreedy {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                //lastPos에 도달할 수 있는지 확인
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }
}
