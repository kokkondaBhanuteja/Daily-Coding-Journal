import java.util.*;
import java.lang.*;
import List.ListNode;

public class MergePointOfList
{
	private static int length(ListNode<Integer> head) {
	    int length = 0;
	    while (head != null) {
	        head = head.next;
	        length++;
	    }
	    return length;
	}

	public static int findIntersection(ListNode<Integer> firstHead, ListNode<Integer> secondHead) {
		
		 // get the length of both list
		int firstListLength = length(firstHead), secondListLength = length(secondHead);
		 
	    // move headA and headB to the same start point
	    while (firstListLength > secondListLength) {
	    	firstHead = firstHead.next;
	        firstListLength--;
	    }
	    
	    while (firstListLength < secondListLength) {
	    	secondHead = secondHead.next;
	    	secondListLength--;
	    }
	    
	    // find the intersection until end
	    while (firstHead != secondHead) {
	    	firstHead = firstHead.next;
	    	secondHead = secondHead.next;
	    }
	    
	    if(firstHead == null)
	    	return -1;
	    
	    return firstHead.data;
	}
	  public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode<Integer> common = new ListNode<>(4);
        common.next = new ListNode<>(5);

        ListNode<Integer> firstHead = new ListNode<>(1);
        firstHead.next = new ListNode<>(2);
        firstHead.next.next = new ListNode<>(3);
        firstHead.next.next.next = common;

        // Creating second linked list: 9 -> 10 -> 4 -> 5
        ListNode<Integer> secondHead = new ListNode<>(9);
        secondHead.next = new ListNode<>(10);
        secondHead.next.next = common;

        // Finding the intersection point
        int intersection = MergePointOfList.findIntersection(firstHead, secondHead);
        System.out.println("Intersection Node: " + intersection);
    }
}