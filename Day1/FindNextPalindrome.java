package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNextPalindrome {
    public static void main(String[] args) {
        System.out.println("Hello World from next palindrome");

        // findNextPalindrome:
        // https://www.educative.io/courses/grokking-coding-interview/next-palindrome-using-same-digits
        System.out.println(findNextPalindrome("12321"));

    }

    public static String findNextPalindrome(String numStr) {
        int len = numStr.length();
        if(len == 1) return "";
        
        List<Character> left = new ArrayList<>();

        for (int i = 0; i < len / 2; i++) {
            left.add(numStr.charAt(i));
        }

        if (!isNextPalindromePossible(left)) {
            return "";
        }

        boolean isOdd = len % 2 != 0 ? true: false;

        StringBuilder answer = new StringBuilder();
        for(char ch : left){
            answer.append(ch);
        }

        if(isOdd){
            answer.append(numStr.charAt(len/2));
            answer.append(new StringBuilder(answer.substring(0,len/2)).reverse());
        } 
        else {
          answer.append(new StringBuilder(answer).reverse());  
        }

        if(answer.toString().equals(numStr)) return "";
        return answer.toString();

    }

    private static boolean isNextPalindromePossible(List<Character> left) {
        int i = left.size()-2;
        int j = left.size()-1;
        
        while(left.get(i) >= left.get(i+1)){
            i--;
        }

        if(i==-1) return false;

        while (left.get(j) <= left.get(i)) {
            j--;
        }

        Collections.swap(left,i,j);
        Collections.reverse(left.subList(i+1, left.size()));
        return true;
    }

}
