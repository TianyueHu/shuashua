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

class LinkedListCycle2_142{
	public ListNode detectCycle(ListNode head) {
        if(head != null){
            ListNode fast = new ListNode(0);
            ListNode slow = new ListNode(0);
            ListNode entry = new ListNode(0);
            fast.next = head;
            slow.next = head;
            entry.next = head;
            
            while(true){
                
                if(fast.next == null) return null;
                fast = fast.next;

                if(fast.next == null) return null;
                fast = fast.next;
                slow = slow.next;
                
                if(fast == slow) {
                    while (entry != slow){
                        entry = entry.next;
                        slow = slow.next;
                    }
                    return entry;
                }
                
            }
        }
        return null;
    }
}