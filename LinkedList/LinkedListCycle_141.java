/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class LinkedListCycle_141{
	public boolean hasCycle(ListNode head) {
        if(head != null){
            ListNode fast = new ListNode(0);
            ListNode slow = new ListNode(0);
            fast.next = head;
            slow.next = head;
            while(true){
                if(fast.next == null) return false;
                fast = fast.next;
                
                if(fast.next == null) return false;
                fast = fast.next;
                slow = slow.next;
                
                if(fast == slow) return true;
            }
        }
        return false;
    }
}