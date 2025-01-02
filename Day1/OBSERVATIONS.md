Things I learned while working on FindNextPalindrome

-  subList() : 
    * Usage in code: 

    ```Collections.reverse(left.subList(i+1, left.size()));```

    * The subList() method of the ArrayList class in Java is used to retrieve a portion of an ArrayList between specified indices. When we perform any modifications to the sub list, that will reflect in the original list and vice versa.

- Collections.swap()
    * Usage in code: 
    ```Collections.swap(left,i,j);```
    
    * swap items at indices i and j

 - new StringBuilder(anotherStringBuilder) : 
    * a new StringBuilder can be created using an existing one

- This question used the "Next Permutation" alogrithm which is as follows:

    To find the next larger number using the same digits of a given number, you can use the following algorithm. This problem is commonly known as the “Next Permutation” problem.



    Algorithm (Next Larger Number Using Digits):

    1. Identify the pivot (rightmost smaller digit):

    • Traverse the digits from right to left.

    • Find the first digit (let’s call it pivot) that is smaller than the digit immediately to its right.

    • If no such digit exists, the number is the largest permutation, and you can return -1.

    2. Find the smallest larger digit:

    • Traverse the digits to the right of the pivot.

    • Find the smallest digit that is larger than the pivot.

    3. Swap the pivot and the smallest larger digit.

    4. Reverse the digits to the right of the pivot:

    • This ensures the smallest possible arrangement of digits to the right of the pivot.

    5. Return the resulting number.
