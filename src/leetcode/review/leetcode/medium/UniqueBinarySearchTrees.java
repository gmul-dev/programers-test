package leetcode.review.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(SolutionRecusive.numTrees(4));
    }

    class SolutionDP {
        Map<Integer, Integer> map = new HashMap();
        public int numTrees(int n) {
            if(n == 0 || n == 1)
                return 1;
            if(map.containsKey(n))
                return map.get(n);
            int count = 0;
            for(int i = 1; i <= n; i++)
                count += numTrees(i - 1) * numTrees(n - i);
            map.put(n, count);
            return map.get(n);
        }
    }

    class SolutionDP2 {
        public int numTrees(int n) {
            int[] way = new int[n+1];
            way[0] = 1;
            way[1] = 1;
            for(int i = 2; i < n; i++) {
                for(int j = 1; j < n; j++) {
                    way[i] += numTrees(j-1)*numTrees(i-j);
                }
            }
            return way[n];
        }
    }

    static class SolutionRecusive {
        public static int numTrees(int n) {
            if(n == 0 || n == 1)
                return 1;
            int count = 0;
            for(int i = 1; i <= n; i++)
                // 현재 값보다 작은 값 left leaf * 현재값보다 큰 값 right leaf
                // 하단 참고
                count += numTrees(i - 1) * numTrees(n - i);
            return count;
        }
    }

    /*
    n = 0;     null

    count[0] = 1


	n = 1;      1

    count[1] = 1


	n = 2;    1__       			 __2
    		      \					/
    		     count[1]	   	count[1]

    count[2] = 1 + 1 = 2


    n = 3;    1__				      __2__	                   __3
    		      \		            /       \			      /
    		  count[2]		  count[1]    count[1]		count[2]

    count[3] = 2 + 1 + 2  = 5


    n = 4;    1__  					__2__					   ___3___
    		      \				 /        \					  /		  \
    		  count[3]		 count[1]    count[2]		  count[2]   count[1]

                 __4
               /
           count[3]

    count[4] = 5 + 2 + 2 + 5 = 14
*/
}
