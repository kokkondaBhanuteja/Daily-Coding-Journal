package List; // Make sure this package is declared

public class DoubleListNode {
    public int data;
    public DoubleListNode next;
    public DoubleListNode prev;

    public DoubleListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Insert a node at the end of DLL
    public static DoubleListNode insert(DoubleListNode head, int data) {
        DoubleListNode newNode = new DoubleListNode(data);
        if (head == null) {
            return newNode;
        }
        DoubleListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    // Print a DLL
    public static void printList(DoubleListNode head) {
        DoubleListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
