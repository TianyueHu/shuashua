class MergekSortedLists_23{
	/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode(-1);
        ListNode ptr = ret;
        while(true){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
                
            for(int i = 0; i < lists.length; ++i){
                if(lists[i] != null && lists[i].val <= min){
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if(minIndex == -1){
                break;
            }
            ptr.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            ptr = ptr.next;
        }
        return ret.next;
    }
}