package princeton;

/******************************************************************************
 *  Compilation:  javac LFSR.java
 *  Execution:    java LFSR n
 *  
 *  Simulate a LFSR for n steps and print results.
 *
 *  % java LFSR 40
 *  0100110010000001100010001011101010111100
 *
 ******************************************************************************/

public class LFSR {

    private static final String LENGTH = "10";

	public static void main(String[] args) { 
        // initial fill
        boolean[] a = {
            false, true, false, false, false,
            false, true, false, true, true, false
        };
        int trials = Integer.parseInt(LENGTH);    // number of steps
        int n = a.length;                          // length of register
        int TAP = 8;                               // tap position


        // Simulate operation of shift register.
        for (int t = 0; t < trials; t++) {

            // Simulate one shift-register step.
            boolean next = (a[n-1] ^ a[TAP]);  // Compute next bit.

            for (int i = n-1; i > 0; i--)
                a[i] = a[i-1];                  // Shift one position.

            a[0] = next;                       // Put next bit on right end.

            if (next) System.out.print("1");
            else      System.out.print("0");    
        }
        System.out.println();    
    }
}
