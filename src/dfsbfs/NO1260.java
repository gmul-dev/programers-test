package dfsbfs;


public class NO1260 {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(solution(new int[][]{{1,1}}));

    }

    public static int solution(int[][] numbers) {

        //return dfs(numbers, target, 0);
        return 0;
    }

    //인접행렬방식
    public static int dfs(int[][] numbers, boolean[] c, int v) {
        int n = numbers.length - 1;
        c[v] = true;

        for(int i = 0; i <= n; i++){
            if(numbers[v][i] == 1 && !c[i]) {
                dfs(numbers, c, i);
            }
        }
        return 0;
    }

    public static int dfs_1(int[][] numbers, boolean[] c, int v) {
        int n = numbers.length - 1;
        c[v] = true;

        for(int i = 0; i <= n; i++){
            if(numbers[v][i] == 1 && !c[i]) {
                dfs(numbers, c, i);
            }
        }
        return 0;
    }
}

