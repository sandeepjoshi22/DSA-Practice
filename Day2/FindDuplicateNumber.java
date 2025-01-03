package Day2;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        // Link to the problem explanation
        // https://www.educative.io/courses/grokking-coding-interview/find-the-duplicate-number

        // Input array containing numbers, where one number is repeated
        int[] nums = {1, 3, 4, 2, 2};

        // Output the duplicate number found in the array
        System.out.println(findDuplicate(nums));
    }

    /**
     * Finds the duplicate number in the array using Floyd's Cycle Detection algorithm.
     * 
     * @param nums - the input array of integers
     * @return the duplicate number in the array
     */
    public static int findDuplicate(int[] nums) {
        // Initialize two pointers: slow and fast, starting from the first element
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect the cycle
        // Move slow pointer by one step and fast pointer by two steps until they meet
        do {
            slow = nums[slow];       // Move slow pointer one step
            fast = nums[nums[fast]]; // Move fast pointer two steps
        } while (slow != fast);

        // Phase 2: Find the starting point of the cycle (duplicate number)
        // Reset slow pointer to the start of the array
        slow = nums[0];

        // Move both pointers one step at a time until they meet again
        while (slow != fast) {
            slow = nums[slow]; // Move slow pointer one step
            fast = nums[fast]; // Move fast pointer one step
        }

        // The meeting point is the duplicate number
        return fast;
    }
}
