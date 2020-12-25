package leetcode.review.leetcode.medium;

public class NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        
        char[][] grid1 = new char[][] {
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        };
        
        System.out.println(Solution.numIslands(grid));
    }

    static class Solution {
        public static int numIslands(char[][] grid) {
            int[][] visited = new int[grid.length][grid[0].length];
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(visited[i][j] == 0 && grid[i][j] == '1') {
                        helper(grid, i, j, visited);
                        count++;
                    }
                }
            }
            return count;
        }

        private static void helper(char[][] grid, int v, int h, int[][] visited) {
            if(v >= grid.length || h >= grid[0].length || v < 0 || h < 0) {
                return;
            }

            if(visited[v][h] == 1 || grid[v][h] == '0') {
                return;
            }

            visited[v][h]++;
            helper(grid, v+1, h, visited);
            helper(grid, v-1, h, visited);
            helper(grid, v, h+1, visited);
            helper(grid, v, h-1, visited);
        }
    }
}
