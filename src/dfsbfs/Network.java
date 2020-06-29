package dfsbfs;


public class Network {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        System.out.println(solution(new int[]{1,1}, 2));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            return  sum == target ? 1 : 0;
        }else {
            return dfs(numbers, target, index + 1, sum + numbers[index])
                    + dfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }
}

