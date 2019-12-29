package hash;

import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        int[] lost = {1,5};
        int[] reserve = {3};

        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"2345","23","13412","22989"}));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i].equals(phone_book[i+1])){
                return false;
            }

            if(phone_book[i].length() < phone_book[i+1].length()){
                if(phone_book[i+1].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return answer;
    }
}


class Solution1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i].equals(phone_book[i+1])){
                return false;
            }

            if(phone_book[i].length() < phone_book[i+1].length()){
                if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
