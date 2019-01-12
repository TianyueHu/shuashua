/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseNodesInKGroup_25 {
    
    
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, post = null, start = head, end = null;
        while(true){
            end = start;
            for(int i = 1; i < k; ++i){
                if(end != null)
                    end = end.next;
                else
                    return newHead.next;
                    
            }
            if(end != null)
                post = end.next;
            else
                break;
            
            swap(pre, post, start, end);
            
            for(int i = 0; i < k; ++i){
                pre = pre.next;
            }
            start = pre.next;
        }
        return newHead.next;

    }
    
   
    private void swap(ListNode pre, ListNode post, ListNode start, ListNode end){
        
        ListNode left = start, right = start.next;
        while(true){
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
            if(left == end)
                break;
        }
        
        pre.next = end;
        start.next = post;
    }
    
}