package leetcode.medium;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                          {'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}
                        };
        System.out.println(Solution.exist(board, "ABCCED"));
    }

    static class Solution {
        public static boolean exist(char[][] board, String word) {

            int wordIndex = 0;
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(wordIndex)) {
                        if(helper(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private static boolean helper(char[][] board, int v, int h, String word, int index, boolean[][] visited) {
            if(word.length() <= index) {
                return true;
            }

            if(v >= board.length || v < 0 || h >= board[0].length || h < 0) {
                return false;
            }

            if(visited[v][h] || board[v][h] != word.charAt(index)) {
                return false;
            }

            visited[v][h] = true;
            boolean result =  helper(board, v+1, h, word, index+1, visited) ||
                helper(board, v-1, h, word, index+1, visited) ||
                helper(board, v, h+1, word, index+1, visited) ||
                helper(board, v, h-1, word, index+1, visited);
            visited[v][h] = false;

            return result;
        }
    }

//    class Solution {
//        public boolean exist(char[][] board, String word) {
//            if (word.length() == 0) {
//                return true;
//            }
//
//            if (board.length == 0 || board[0].length == 0) {
//                return false;
//            }
//
//            char[] wordArray = word.toCharArray();
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    if (existBackTracking(board, i, j, wordArray, 0)) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//
//        }
//
//        private boolean existBackTracking(char[][] board,
//                                          int row,
//                                          int column,
//                                          char[] word,
//                                          int charIndex) {
//            if (word.length == charIndex) {
//                return true;
//            }
//
//            if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word[charIndex]) {
//                return false;
//            }
//
//            board[row][column] ^= 256;
//            boolean result = existBackTracking(board, row + 1, column, word, charIndex + 1)
//                    || existBackTracking(board, row - 1, column, word, charIndex + 1)
//                    || existBackTracking(board, row, column + 1, word, charIndex + 1)
//                    || existBackTracking(board, row, column - 1, word, charIndex + 1);
//            board[row][column] ^= 256;
//            return result;
//        }
//    }
}
