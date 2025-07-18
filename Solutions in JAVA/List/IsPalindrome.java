public class isPalindrome
{
	static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 private ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode curr = node,temp = node,prev = null;
        while(curr!=null){
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if( head==null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast !=null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow !=null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow= slow.next;
        }
        return true;
    }

	public static void main(String[] args){
		
	}
}