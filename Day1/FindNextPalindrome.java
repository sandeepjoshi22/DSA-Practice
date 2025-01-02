package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNextPalindrome {
    public static void main(String[] args) {

        // Test case for the findNextPalindrome method.https://www.educative.io/courses/grokking-coding-interview/next-palindrome-using-same-digits
        // Input: "12321", Output: Next palindrome using the same digits or "" if not possible.
        System.out.println(findNextPalindrome("12321"));

    }

    /**
     * Finds the next palindrome number that can be formed using the same digits of the given number.
     * @param numStr the input number represented as a string.
     * @return the next palindrome number as a string, or an empty string if no such palindrome is possible.
     */
    public static String findNextPalindrome(String numStr) {
        int len = numStr.length();
        if(len == 1) return ""; // Single-digit numbers cannot have a "next" palindrome.
        
        // Extract the left half of the number.
        List<Character> left = new ArrayList<>();
        for (int i = 0; i < len / 2; i++) {
            left.add(numStr.charAt(i));
        }

        // Check if rearranging the digits of the left half can form a higher number.
        if (!isNextPalindromePossible(left)) {
            return ""; // No next palindrome possible.
        }

        boolean isOdd = len % 2 != 0; // Check if the input length is odd.

        // Build the next palindrome.
        StringBuilder answer = new StringBuilder();
        for(char ch : left){
            answer.append(ch);
        }

        if(isOdd){
            // If the number length is odd, include the middle character.
            answer.append(numStr.charAt(len/2));
            answer.append(new StringBuilder(answer.substring(0,len/2)).reverse());
        } 
        else {
            // For even lengths, mirror the left half.
            answer.append(new StringBuilder(answer).reverse());  
        }

        // If the generated palindrome is the same as the input, return an empty string.
        if(answer.toString().equals(numStr)) return "";
        return answer.toString();
    }

    /**
     * Checks if it's possible to rearrange the digits of the left half to form a larger number.
     * Performs a modification similar to finding the next permutation.
     * @param left the left half of the number represented as a list of characters.
     * @return true if a higher number can be formed, false otherwise.
     */
    private static boolean isNextPalindromePossible(List<Character> left) {
        int i = left.size()-2; // Start from the second last index of the left half.
        int j = left.size()-1; // Start from the last index of the left half.
        
        // Step 1: Find the first digit that is smaller than the digit next to it, traversing from right to left.
        while(i >= 0 && left.get(i) >= left.get(i+1)){
            i--;
        }

        if(i == -1) return false; // If no such digit is found, it's not possible to form a higher number.

        // Step 2: Find the smallest digit to the right of 'i' that is larger than left.get(i).
        while (left.get(j) <= left.get(i)) {
            j--;
        }

        // Step 3: Swap the two digits found in the previous steps.
        Collections.swap(left,i,j);

        // Step 4: Reverse the digits to the right of 'i' to get the smallest possible arrangement.
        Collections.reverse(left.subList(i+1, left.size()));
        return true;
    }
}
