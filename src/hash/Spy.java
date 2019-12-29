package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Spy {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        Solution solution = new Solution();
        System.out.println(SpySolution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}

class SpySolution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        int clotheLength = clothes.length;
        Map<String, Integer> itemMap = new HashMap<>();

        for(int i = 0; i < clotheLength; i++) {
            String itemKey = clothes[i][1];
            if (itemMap.containsKey(itemKey)) {
                itemMap.put(itemKey, itemMap.get(itemKey) + 1);
            } else {
                itemMap.put(itemKey, 1);
            }
        }

        Set<String> keySet = itemMap.keySet();
        for(String key : keySet){
            answer *= (itemMap.get(key) + 1);
        }

        return answer - 1;
    }
}
