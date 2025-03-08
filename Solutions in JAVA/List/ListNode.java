package List;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    // Insert method for LinkedList (at the end)
    public static ListNode<Integer> insert(ListNode<Integer> head, int key) {
        if (head == null) return new ListNode<>(key);
        ListNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode<>(key);
        return head;
    }

    // Utility method to print LinkedList
    public static void printList(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}