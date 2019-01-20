/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class ReverseLinkedList_206{
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = head, post = head.next;
        head.next = null;
            
        while(post != null){
            ListNode tempNext = post.next;
            post.next = pre;
            pre = post;
            post = tempNext;
        }
        return pre;
    }
}