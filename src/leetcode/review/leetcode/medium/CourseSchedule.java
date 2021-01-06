package leetcode.review.leetcode.medium;

import java.util.ArrayList;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(Solution.canFinish(3, new int[][]{{1,2}, {1,0}, {2,1}}));
    }

    static class Solution {

        public static boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            int[] visited;

            for(int i=0; i<numCourses; i++){
                graph[i]=new ArrayList<>();
            }

            for(int[] edge: prerequisites){
                graph[edge[0]].add(edge[1]);
            }

            visited = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                if(visited[i]==0){
                    if(!DFS(i, graph, visited)){
                        return false;
                    }
                }
            }
            return true;
        }
        public static boolean DFS(int node, ArrayList<Integer>[] graph, int[] visited){
            if(visited[node]==1){
                return false;
            }
            if(visited[node]==2){
                return true;
            }
            visited[node]=1;
            for(int a: graph[node]){
                if(visited[a]!=2){
                    if(!DFS(a, graph, visited)){
                        return false;
                    }
                }
            }
            visited[node]=2;
            return true;
        }
    }
}
