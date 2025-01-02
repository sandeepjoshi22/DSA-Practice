package Day1;

public class CircularArrayLoop {
    public static void main(String[] args) {

        // ifLoopExists:
        // https://www.educative.io/courses/grokking-coding-interview/circular-array-loop
        int[] nums = { 3, 1, 2 };
        System.out.println(circularArrayLoop1(nums));
        System.out.println(circularArrayLoop2(nums));
    }

    
    /**
     * Version 1: Detects if a circular array loop exists using two pointers.
     * @param nums the input array of integers.
     * @return true if a loop exists, false otherwise.
     */
    public static boolean circularArrayLoop1(int[] nums) {

        if (nums.length == 1)
            return false; // A single-element array cannot have a loop.

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean prevDir = nums[i] > 0; // Direction of movement based on the sign of nums[i].

            while (true) {
                // Move slow pointer one step.
                slow = nextPointer(slow, nums);
                if (isNotCycle(slow, prevDir, nums))
                    break;

                // Move fast pointer two steps.
                fast = nextPointer(fast, nums);
                if (isNotCycle(fast, prevDir, nums))
                    break;
                fast = nextPointer(fast, nums);
                if (isNotCycle(fast, prevDir, nums))
                    break;

                // If slow and fast pointers meet, a cycle is detected.
                if (slow == fast)
                    return true;
            }
        }

        return false; // No cycle found.
    }

    /**
     * Computes the next pointer index in the array, wrapping around if necessary.
     * @param pointer the current index.
     * @param nums the input array.
     * @return the next pointer index.
     */
    public static int nextPointer(int pointer, int[] nums) {
        int result = (pointer + nums[pointer]) % nums.length;
        if (result < 0) {
            result += nums.length; // Handle negative wrapping.
        }

        return result;
    }

    /**
     * Determines if the current pointer state breaks the cycle condition.
     * @param pointer the current index.
     * @param prevDir the previous direction of movement.
     * @param nums the input array.
     * @return true if it's not a cycle, false otherwise.
     */
    public static boolean isNotCycle(int pointer, boolean prevDir, int[] nums) {
        boolean nextDir = nums[pointer] > 0; // Determine direction at the current index.

        // A cycle is broken if the direction changes or the step size is zero.
        if (prevDir != nextDir || nums[pointer] % nums.length == 0)
            return true;

        return false;
    }

    /**
     * Version 2: Optimized cycle detection with improved handling of single-element loops.
     * @param nums the input array of integers.
     * @return true if a loop exists, false otherwise.
     */
    public static boolean circularArrayLoop2(int[] nums) {
        if (nums.length == 1)
            return false; // A single-element array cannot have a loop.

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean prevDir = nums[i] > 0; // Direction of movement based on the sign of nums[i].

            while (true) {
                // Move slow pointer one step.
                slow = nextPointer2(slow, nums, prevDir);

                // Move fast pointer two steps.
                fast = nextPointer2(fast, nums, prevDir);
                if (fast != -1) {
                    fast = nextPointer2(fast, nums, prevDir);
                }

                // If pointers meet, a cycle is detected.
                if (slow != -1 && slow == fast) {
                    // Check for single-element loops.
                    if (slow == nextPointer2(slow, nums, prevDir)) {
                        break;
                    }

                    return true;
                }
                // If fast or slow pointer becomes invalid, break.
                if (slow == -1 || fast == -1) break;
            }
        }
        return false; // No cycle found.
    }

    /**
     * Computes the next pointer index in the array for version 2, with additional validations.
     * @param current the current index.
     * @param nums the input array.
     * @param prevDir the previous direction of movement.
     * @return the next pointer index, or -1 if invalid.
     */
    public static int nextPointer2(int current, int[] nums, boolean prevDir) {

        boolean currDir = nums[current] > 0; // Determine direction at the current index.
        if (currDir != prevDir) return -1; // Direction change invalidates the cycle.

        int next = (current + nums[current]) % nums.length;
        if (next < 0) {
            next += nums.length; // Handle negative wrapping.
        }

        // If next is the same as current, return -1 (single-element loop).
        if (next == current) return -1;

        return next;
    }
}
