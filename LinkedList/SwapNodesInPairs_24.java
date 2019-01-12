class SwapNodesInPairs_24{
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, post = newHead.next;
        
        while(true){
            swap(pre, post);
            if(pre.next != null && pre.next.next != null){
                post = pre.next.next.next;
                pre = pre.next.next;
            }
            else
                break;
        }
        return newHead.next;
    }
    
    private void swap(ListNode pre, ListNode post){
        if(post == null || post.next == null)
             return;
        ListNode postNext = post.next.next;
        pre.next = post.next;
        post.next.next = post;
        post.next = postNext;
    }
}