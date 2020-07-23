package leetcode.medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        Solution.rotate(matrix);
    }

    /*
      [1,2,3]     [7 8 9]     [7 4 1]
      [4,5,6] =>  [4 5 6] =>  [8 5 2]
      [7,8,9]     [1 2 3]     [9 6 3]
    */
    static class Solution {
        public static void rotate(int[][] matrix) {
            int n = matrix.length;
            if (n == 0) return;
            swapByHorizontal(matrix);
            swapByBackSlash(matrix);
        }

        private static void swapByBackSlash(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i ++) {
//                for (int j = matrix.length - 1; j > i; j --) {
//                    int x = j;
//                    int y = i;
//                    swap(matrix, i, j, x, y);
//                }
                for(int j = i + 1; j < matrix.length; j++) {
                    int x = j;
                    int y = i;
                    swap(matrix, i, j, x, y);
                }
            }
        }

        private static void swapByHorizontal(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i ++) {
                int x = matrix.length - 1 - i;
                for (int j = 0; j < matrix.length; j ++) {
                    swap(matrix, i, j, x, j);
                }
            }
        }

        private static void swap(int[][] matrix, int i, int j, int x, int y) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[x][y];
            matrix[x][y] = temp;
        }
    }
}
