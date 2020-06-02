package leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1233233321));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0) return false;

            int xLength = (int)(Math.log10(x)+1);
            if(xLength == 1) return true;

            for(int i=0; i <= xLength/2; i++) {
                int temp = (int) (x/(Math.pow(10,i))%10);
                int temp2 = (int) (x/(Math.pow(10,(xLength-i-1)))%10);
                if(temp != temp2) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isPalindromeBest(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;
    }

    public boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        if(x<10)
            return true;

        int n=1,x_cpy=x;
        while(x_cpy/10!=0) {
            n++;
            x_cpy=x_cpy/10;
        }
        for(int i=0;i<n/2;i++) {
            int end=x/(int)Math.pow(10, i)%10;
            int start=x/(int)(Math.pow(10, n-i-1))%10;
            if(start!=end)
                return false;
        }
        return true;
    }
}


