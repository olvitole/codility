package basicsOfCoding;

public class OlvisLinkedListTest {

	
	public static void main (String args[]){
		
		// end node example
		OlvisLinkedListNode top = new OlvisLinkedListNode();
		top.name = "A";
		top.next = null;
		printElements(top);

		// insert node before the first
		OlvisLinkedListNode temp = null;
		temp = new OlvisLinkedListNode();
		temp.name = "B";
		temp.next = top;
		top = temp;
		
		printElements(top);
		
		// insert node after last
		temp = new OlvisLinkedListNode();
		temp.name = "C";

		OlvisLinkedListNode temp2 = null;
		temp2 = top;
		while (temp2.next!=null){
			temp2 = temp2.next;
		}
		temp2.next = temp;
		printElements(top);
			
		
		// insert node between A and C
		temp = new OlvisLinkedListNode();
		temp.name = "D";
		
		temp2 = top;
		
		while(temp2 != null && temp2.name != "A"){
			temp2 = temp2.next; // navigate until find A
		}
		
		temp.next = temp2.next;
		temp2.next = temp;
		
		printElements(top);
		
		// delete the first node
		top = top.next;
		printElements(top);
		

	}
	
	private static void printElements(OlvisLinkedListNode top){
		
		// linear navigate to final node
		OlvisLinkedListNode temp = top;
		while (temp !=null){
			System.out.print(temp.name + " ");
			temp = temp.next;
		}
		System.out.println();	
	}
	
}
