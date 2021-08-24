package leetcode.medium;

public class NumberofIslands {
    public static void main(String[] args) {

    }

    class Solution {
        public void DFS(char[][] grid, int row, int col)
        {
            int h = grid.length;
            int l = grid[0].length;
            if(row<0 || col<0 || row>=h || col>=l || grid[row][col]!='1')
                return ;

            grid[row][col] = '0';

            DFS(grid, row, col-1);     // left
            DFS(grid, row, col+1);   // right
            DFS(grid, row+1, col);   // down
            DFS(grid, row-1, col);    // up
        }

        public int numIslands(char[][] grid) {
            int h = grid.length;
            if (h == 0) return 0;
            int l = grid[0].length;
            int res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (grid[i][j] == '1') {
                        DFS(grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }
    }

    class SolutionBFS {
        public int numIslands(char[][] grid) {

            int islands = 0;
            int[] next = new int[]{0, 0};

            while(found(grid, next)) {
                bfs(grid, next[0], next[1]);
                islands++;
            }
            return islands;
        }

        private boolean found(char[][] grid, int[] next) {

            for(int i = next[0]; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1') {
                        next[0] = i;
                        next[1] = j;
                        return true;
                    }
                }
            }
            return false;
        }

        private void bfs(char[][] grid, int i, int j) {
            if(grid[i][j] == '1') {
                grid[i][j] = '0';

                if(i - 1 >= 0)
                    bfs(grid, i - 1, j);

                if(i + 1 < grid.length)
                    bfs(grid, i + 1, j);

                if(j - 1 >= 0)
                    bfs(grid, i, j - 1);

                if(j + 1 < grid[0].length)
                    bfs(grid, i, j + 1);
            }
        }
    }
}
