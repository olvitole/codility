package amazon;

public class TestExcercise {


    public static void main (String[] args){

        int from = 10;
        int to = 15;

        printNumbers(from, to);


    }


    private static void printNumbers(int from, int to){
    
        // note inclusive
        for (int i =from; i <= to; i++){
            System.out.print(i+" ");
        }
    
        System.out.println();
    
    }



}