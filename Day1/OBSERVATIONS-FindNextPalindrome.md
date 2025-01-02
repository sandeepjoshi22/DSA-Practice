# Things I Learned While Working on FindNextPalindrome

## Methods and Concepts Used

### 1. **`subList()`**
   - **Usage in code:**  
     ```java
     Collections.reverse(left.subList(i + 1, left.size()));
     ```
   - **Description:**  
     The `subList()` method of the `ArrayList` class in Java is used to retrieve a portion of an `ArrayList` between specified indices. Modifications made to the sublist will reflect in the original list, and vice versa.

### 2. **`Collections.swap()`**
   - **Usage in code:**  
     ```java
     Collections.swap(left, i, j);
     ```
   - **Description:**  
     Swaps the items at indices `i` and `j` within the list.

### 3. **Creating a New `StringBuilder` from Another**
   - **Usage:**  
     A new `StringBuilder` object can be created using an existing `StringBuilder` as a parameter.  
     Example:  
     ```java
     StringBuilder sb = new StringBuilder(anotherStringBuilder);
     ```

---

## Algorithm Used: Next Permutation

This problem leverages the **Next Permutation** algorithm to find the next larger number using the same digits of a given number.

### Steps of the Algorithm:

1. **Identify the Pivot (Rightmost Smaller Digit):**
   - Traverse the digits from right to left.
   - Find the first digit (referred to as the *pivot*) that is smaller than the digit immediately to its right.
   - If no such digit exists, the number is the largest permutation, and you can return `-1`.

2. **Find the Smallest Larger Digit:**
   - Traverse the digits to the right of the pivot.
   - Find the smallest digit that is larger than the pivot.

3. **Swap the Pivot and the Smallest Larger Digit:**
   - Swap the identified pivot and the smallest larger digit.

4. **Reverse the Digits to the Right of the Pivot:**
   - Reverse all digits to the right of the pivot. This ensures the smallest possible arrangement of digits to the right of the pivot.

5. **Return the Resulting Number.**

--- 
