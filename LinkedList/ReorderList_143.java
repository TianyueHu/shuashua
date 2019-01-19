class ReorderList_143{
	
	public void reorderList(ListNode head) {
        ListNode ptr = head;
        int len = 0;
        while(ptr != null){
            ++len;
            ptr = ptr.next;
        }
        if(len <= 2) return;
        int helf = (len - 1) / 2;
        Stack<ListNode> stack = new Stack<ListNode>();
        ptr = head;
        while(helf > 0){
            --helf;
            stack.push(ptr);
            ptr = ptr.next;
        }
        
        ListNode end = (len % 2 == 0) ? ptr.next : ptr;
        while(!stack.isEmpty() && end.next != null){
            ListNode node = stack.pop();
            ListNode next = end.next;
            end.next = next.next;
            next.next = node.next;
            node.next = next;
        }
    }
}