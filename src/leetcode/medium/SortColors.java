package leetcode.medium;

public class SortColors {
    public static void main(String[] args) {
        int[] params = new int[]{2,0,2,1,1,0};
        SolutionBest.sortColors(params);
        System.out.println(params);
    }

    static class SolutionBest {
        public static void sortColors(int[] nums) {
            int left = 0;
            int mid = 0;
            int high = nums.length - 1;

            while (mid <= high) {
                if (nums[mid] == 0) {
                    int temp = nums[left];
                    nums[left] = nums[mid];
                    nums[mid] = temp;
                    left++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else {
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    //mid는 숫자를 다시 판별해야하므로 +1 하지 않음
                }
            }
        }
    }
}
