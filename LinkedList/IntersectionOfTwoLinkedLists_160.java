/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class IntersectionOfTwoLinkedLists_160{
	int lenA = 0, lenB = 0;
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != null){
            ++lenA;
            ptrA = ptrA.next;
        }
        while (ptrB != null){
            ++lenB;
            ptrB = ptrB.next;
        }
        ptrA = lenA > lenB ? headA : headB;
        ptrB = ptrA == headA ? headB : headA;
        
        int len = Math.max(lenA, lenB) - Math.min(lenA, lenB);
        
        while(len > 0){
            --len;
            ptrA = ptrA.next;
        }
        
        while(ptrA != null){
            if(ptrA == ptrB){
                return ptrA;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
}