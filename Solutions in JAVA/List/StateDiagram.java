import java.util.*;

public class StateDiagram {
    public static void main(String[] args) {
        // Example: Diagram to accept "abc" via next, or "adc" via random
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');
        Node<Character> c = new Node<>('c');
        Node<Character> d = new Node<>('d');

        // Set transitions
        a.next = b;
        b.next = c;

        a.random = d;
        d.next = c;

        // Sample input strings
        String str1 = "abc";  // valid through next
        String str2 = "adc";  // valid through random then next
        String str3 = "abd";  // invalid

        System.out.println("Is \"" + str1 + "\" accepted? " + isItAccepted(a, str1));  // true
        System.out.println("Is \"" + str2 + "\" accepted? " + isItAccepted(a, str2));  // true
        System.out.println("Is \"" + str3 + "\" accepted? " + isItAccepted(a, str3));  // false
    }

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> random;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static boolean isItAccepted(Node<Character> head, String str) {
        Node<Character> temp = new Node<Character>('1');  // dummy node
        temp.next = head;
        boolean ans = true;
        int n = str.length();
        int i = 0;

        while (i <= n) {
            if (i == n) {
                ans = (temp.next == null);
                break;
            } else if (temp.next != null && temp.next.data == str.charAt(i)) {
                temp = temp.next;
                i++;
            } else if (temp.random != null && temp.random.data == str.charAt(i)) {
                temp = temp.random;
                i++;
            } else {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
