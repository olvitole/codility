package crackingthecoding.misc;

public class LinkedListNode {
	public LinkedListNode next = null;
	public int data;
	
	// 	used in 2.5
	public LinkedListNode prev = null;


	public LinkedListNode(int d) {
		data = d;
	}

	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public void appendToTail(LinkedListNode d) {
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = d;
	}

	@Override
	public String toString() {
		return "LinkedListNode [next=" + next + ", data=" + data + "]";
	}
	
	

}
