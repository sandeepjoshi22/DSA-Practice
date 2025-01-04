package Day3;

// Class to compute the maximum twin sum of a linked list
public class MaxTwinSumLinkedList {

    // Method to calculate the maximum twin sum of a linked list
    public static int twinSum(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        // Find the middle of the linked list using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        LinkedListNode<Integer> rightHead = reverse(slow);
        LinkedListNode<Integer> leftHead = head;

        int maxSum = Integer.MIN_VALUE;

        // Calculate the maximum twin sum
        while (rightHead != null) {
            maxSum = Math.max(maxSum, leftHead.data + rightHead.data);
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        return maxSum;
    }

    // Method to reverse a linked list starting from a given node
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> slow) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> curr = slow;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Main method to test the twinSum function
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        // Calculate the maximum twin sum and print the result
        int result = twinSum(head);
        System.out.println("The maximum twin sum of the linked list is: " + result);

        // Test with another linked list: 5 -> 6 -> 7 -> 8
        LinkedListNode<Integer> head2 = new LinkedListNode<>(5);
        head2.next = new LinkedListNode<>(6);
        head2.next.next = new LinkedListNode<>(7);
        head2.next.next.next = new LinkedListNode<>(8);

        result = twinSum(head2);
        System.out.println("The maximum twin sum of the second linked list is: " + result);
    }

    // Definition for LinkedListNode
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        // Constructor to initialize a node
        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

