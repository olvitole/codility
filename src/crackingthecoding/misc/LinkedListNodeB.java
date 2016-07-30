package crackingthecoding.misc;

public class LinkedListNodeB {
	public LinkedListNodeB next;
	public LinkedListNodeB prev;
	public LinkedListNodeB last;
	public int data;

	public LinkedListNodeB(int d, LinkedListNodeB n, LinkedListNodeB p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}

	public LinkedListNodeB() {
	}

	public void setNext(LinkedListNodeB n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}

	public void setPrevious(LinkedListNodeB p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}

	public LinkedListNodeB clone() {
		LinkedListNodeB next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNodeB head2 = new LinkedListNodeB(data, next2, null);
		return head2;
	}
}