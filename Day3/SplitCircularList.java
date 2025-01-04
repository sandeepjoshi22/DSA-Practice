package Day3;

public class SplitCircularList {

    public static void main(String[] args) {
        // https://www.educative.io/courses/grokking-coding-interview/split-a-circular-linked-list
        // Create a circular linked list: 1 -> 2 -> 3 -> 4 -> 5 -> back to 1
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = head; // Make it circular
    
        // Split the circular linked list
        LinkedListNode[] result = splitCircularLinkedList(head);
    
        // Print the two halves
        System.out.println("First half:");
        printCircularList(result[0]);
    
        System.out.println("Second half:");
        printCircularList(result[1]);
    }
    
    // Helper method to print a circular linked list
    public static void printCircularList(LinkedListNode head) {
        if (head == null) return;
    
        LinkedListNode current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.value + ")");
    }


    public static LinkedListNode[] splitCircularLinkedList(LinkedListNode head) {
        if (head == null || head.next == head) {
            // If the list is empty or has only one node, return as is
            return new LinkedListNode[]{head, null};
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // `slow` is now at the end of the first half
        // The head of the second half is the next node after `slow`
        LinkedListNode leftHead = head;
        LinkedListNode rightHead = slow.next;

        // Break the circular connections to split the list into two halves
        slow.next = leftHead; // Close the first half as a circular list

        // Traverse to the end of the second half to close it
        LinkedListNode current = rightHead;
        while (current.next != head) { // Traverse until the original circular link
            current = current.next;
        }
        current.next = rightHead; // Close the second half as a circular list

        // Return the two halves
        return new LinkedListNode[]{leftHead, rightHead};
    }
    
    // Definition for LinkedListNode
    static class LinkedListNode {
        int value;
        LinkedListNode next;
    
        LinkedListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
