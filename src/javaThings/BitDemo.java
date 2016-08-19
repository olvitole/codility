package javaThings;

public class BitDemo {
	public static void main(String[] args) {

		// and
		System.out.println("& " + Integer.toBinaryString(1&1));
		System.out.println("& " + Integer.toBinaryString(1&0));
		System.out.println("& " + Integer.toBinaryString(0&1));
		System.out.println("& " + Integer.toBinaryString(0&0));

		// exclusive or
		System.out.println("^ " + Integer.toBinaryString(1^1));
		System.out.println("^ " + Integer.toBinaryString(1^0));
		System.out.println("^ " + Integer.toBinaryString(0^1));
		System.out.println("^ " + Integer.toBinaryString(0^0));
		
		//inclusive or
		System.out.println("| " + Integer.toBinaryString(1|1));
		System.out.println("| " + Integer.toBinaryString(1|0));
		System.out.println("| " + Integer.toBinaryString(0|1));
		System.out.println("| " + Integer.toBinaryString(0|0));
		
		System.out.println("~ " + Integer.toBinaryString(~0));
		System.out.println("~ " + Integer.toBinaryString(~1));

		
		System.out.println("<< " + Integer.toBinaryString(7<<1));
		System.out.println(">> " + Integer.toBinaryString(7>>1));
		System.out.println(">>> " + Integer.toBinaryString(7>>>1));
		
		
		int a = 52; // 52 = 0011 0100 
        int b = 13; // 13 = 0000 1101 
        int c = 0;
        c = a & b; // 4  = 0000 0100    // LINE A 
        System.out.println("a & b = " + c);
        c = a | b; // 61 = 0011 1101    // LINE B
        System.out.println("a | b = " + c);
        c = a ^ b; // 57 = 0011 1001    // LINE C
        System.out.println("a ^ b = " + c);
        c = ~a; // -4 = 1111 1011    // LINE D
        System.out.println("~a = " + c);
        c = a << 2; // 208 = 1101 0000    // LINE E
        System.out.println("a << 2 = " + c);
        c = a >> 2; // 13 = 0000 1101    // LINE F
        System.out.println("a >> 2  = " + c);
        c = a >>> 2; // 13 = 0000 1101 // LINE G
        System.out.println("a >>> 2 = " + c);    

		int bitmask = 0x000F;
		System.out.println("bitmask:" + bitmask);
		System.out.println("binary string:           " + Integer.toBinaryString(bitmask));

		int val = 0x2222;
		System.out.println("val: " + val);
		System.out.println("binary string: " + Integer.toBinaryString(val));
		System.out.println("");

		System.out.println("bitwise & :");
		// prints "2"
		int out = val & bitmask;
		System.out.println(out);
		System.out.println("binary string: " + Integer.toBinaryString(out));

		System.out.println("bitwise ^ :");
		out = val ^ bitmask;
		System.out.println(out);
		System.out.println("binary string: " + Integer.toBinaryString(out));

	}
}