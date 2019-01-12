class CopyListWithRandomPointer_138{

	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

	public RandomListNode createAList(int type){
		if(type == 1){
			return null;
		}
		else if(type == 2){
			return new RandomListNode(1);
		}
		else if(type == 3){
			RandomListNode node1 = new RandomListNode(1);
    		RandomListNode node2 = new RandomListNode(2);
    		node1.next = node2;
    		node1.random = node2;
    		node2.random = node1;
    		return node1;
		}
		else if(type == 4){
			RandomListNode node1 = new RandomListNode(1);
    		RandomListNode node2 = new RandomListNode(2);
    		RandomListNode node3 = new RandomListNode(3);
    		node1.next = node2;
    		node2.next = node3;
    		node1.random = node3;
    		node2.random = node1;
    		node3.random = node2;
    		return node1;
		}
		else {
			RandomListNode node1 = new RandomListNode(1);
	    	RandomListNode node2 = new RandomListNode(2);
	    	RandomListNode node3 = new RandomListNode(3);
	    	RandomListNode node4 = new RandomListNode(4);
	    	RandomListNode node5 = new RandomListNode(5);
	    	node1.next = node2;
	    	node2.next = node3;
	    	node3.next = node4;
	    	node4.next = node5;

	    	node1.random = node3;
	    	node2.random = node5;
	    	node3.random = node2;
	    	node4.random = node1;
	    	node5.random = node4;
	    	return node1;
	    }
	}

	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        
        RandomListNode node = head;
        while(node != null){
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        node = head;
        while(node != null){
            if(node.next != null){
                node.next.random = node.random == null ? null : node.random.next;
                node = node.next.next;
            }
            else
                break;
        }
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        node = head;
        while (copy != null){
            node.next = copy.next;
            copy.next = node.next == null ? null : node.next.next;
            node = node.next;
            copy = copy.next;
        }
        return copyHead;
    }

    public static void printList(RandomListNode head){
    	if(head == null)
    		System.out.println("Head is null");

    	while(head != null){
    		System.out.print(head.label);
    		System.out.print("(" + (head.random == null ? "null" : head.random.label) + ")");
    		if(head.next != null){
    			System.out.print("->");
    			head = head.next;
    		}
    		else
    			break;
    	}
    	System.out.println();
    	System.out.println();
    }

    public static void main(String[] args){
    	CopyListWithRandomPointer_138 c = new CopyListWithRandomPointer_138();

    	for(int type = 1; type < 6; ++type){
    		RandomListNode node1 = c.createAList(type);
			CopyListWithRandomPointer_138.printList(node1);
	    	RandomListNode copyHead = c.copyRandomList(node1);
	    	//CopyListWithRandomPointer_138.printList(node1);
	    	CopyListWithRandomPointer_138.printList(copyHead);
    	}
    }
}