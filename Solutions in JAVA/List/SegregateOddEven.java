public class SegregateOddEven {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node segregate(Node head) {
        Node oddHead = null;
        Node evenHead = null;
        Node oddTail = null;
        Node evenTail = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 1) {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = oddHead;
                } else {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = evenHead;
                } else {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            }
            temp = temp.next;
        }
        if (oddHead == null || evenHead == null) {
            return head;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);

        Node newHead = segregate(head);

        System.out.println("List after segregating odd and even nodes:");
        printList(newHead);
    }
}
