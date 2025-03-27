package List;
import java.util.*;



public class ReverseDLL_in_Groups {
	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
		}
	}
// Main method
    public static void main(String[] args) {
        Node head = null;

        // Insert nodes into DLL
        head = insert(head, 8);
        head = insert(head, 9);
        head = insert(head, 10);
        head = insert(head, 11);
        head = insert(head, 12);

        int k = 3;
        System.out.print("Original List: ");
        printList(head);

        head = reverseDLLInGroups(head, k);

        System.out.print("Reversed in Groups of " + k + ": ");
        printList(head);
    }
    // Function to reverse DLL in groups of k
    public static Node reverseDLLInGroups(Node head, int k) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;
        int count = 0;

        // Reverse first 'k' nodes
        while (curr != null && count < k) {
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            count++;
        }

        // Recursive call for remaining nodes
        if (curr != null) {
            head.next = reverseDLLInGroups(curr, k);
            if (head.next != null) {
                head.next.prev = head;
            }
        }

        return prev; // 'prev' is the new head of the reversed part
    }

    // Function to insert a node at the end of DLL
    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    // Function to print a DLL
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
}
