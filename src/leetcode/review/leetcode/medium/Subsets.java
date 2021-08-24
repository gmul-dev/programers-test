package leetcode.review.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(Solution.subsets(new int[]{1,2,3,4,5}));
    }

    static class Solution {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list=new ArrayList();
            subsetGeneratorBitWise(list,nums);
            //subsetGenerator(nums,list,new ArrayList(),0);
            return list;
        }

        public static void subsetGeneratorBitWise(List<List<Integer>> list, int[] nums){
            int n=nums.length;
            for(int i=0;i< 1<<n ; i++){
                List<Integer> e=new ArrayList();
                for(int j=0;j<n;j++){
                    if((i & (1<<j))>0){
                        e.add(nums[j]);
                    }
                }
                list.add(e);
            }
        }
        public static void subsetGenerator(int nums[],List<List<Integer>> result,List<Integer> current,int index){

            result.add(new ArrayList(current));
            for(int i=index;i<nums.length;i++){
                current.add(nums[i]);
                subsetGenerator(nums,result,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }

    static class mySolution {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            helper(nums, 0, new ArrayList<>(), result);
            return result;
        }

        private static void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
            if(index == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            list.add(nums[index]);
            helper(nums, index+1, list, result);
//            list.remove(list.indexOf(nums[index]));
            list.remove(list.size()-1);
            helper(nums, index+1, list, result);
        }
    }
}
