package leetcode.medium;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(Solution.canFinish(2, new int[][]{{1,0}}));
    }

    static class Solution {
        public static boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++)
                graph[i] = new ArrayList<Integer>();
            boolean[] memo = new boolean[numCourses];
            boolean[] visited = new boolean[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if(!dfs(graph, visited, i, memo)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] memo){
            if (visited[course]) {
                return false;
            }

            if (memo[course]) {
                return true;
            }
            visited[course] = true;
            for (int i = 0; i < graph[course].size(); i++) {
                if (!dfs(graph, visited, (int)graph[course].get(i), memo)) {
                    return false;
                }
            }
            visited[course] = false;
            memo[course] = true;
            return true;
        }
    }

    class SolutionTopologySort {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree=new int[numCourses];
            int count=0;

            for(int i=0;i<prerequisites.length;i++){
                indegree[prerequisites[i][0]]++;
            }
            Stack<Integer> stack=new Stack<>();

            for(int i=0;i<indegree.length;i++){
                if(indegree[i]==0){
                    stack.push(i);
                }
            }

            while(!stack.isEmpty()){
                int curr=stack.pop();
                count++;
                for(int i=0;i<prerequisites.length;i++){
                    if(prerequisites[i][1]==curr){
                        indegree[prerequisites[i][0]]--;
                        if(indegree[prerequisites[i][0]]==0){
                            stack.push(prerequisites[i][0]);
                        }
                    }
                }
            }
            return count==numCourses;
        }
    }
}
