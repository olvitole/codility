package funExcercises;
public class TestExcercise {


    // driving method

    public static void main (String[] args){

        Link top;
        
        
        // L2 -> L1

        // L4 -> L3 -> L2 -> L1
        
        // 3 -> 2  -> 1 -> 0



    }
    
    
    Link findNthToLast(Link lnk, int n){
    
        if(lnk == null)
            return null;
        if (n < 0){
            return null;
        }        
    
        Link temp = lnk;
        
        int toCnt = findNthLinkPosition(lnk);
                
        while( toCnt !=n && temp != null){
            toCnt--;
            temp = temp.next;
        }
    
        return temp;
    
    
    }
    
    
    int findNthLinkPosition(Link lnk){
    
        int position =0;
        
        while(lnk.next.next != null){
            position ++;
        }
    
        return position;
    
    }
    
    
    class Link {
    
        public int id;
        public Link next;
    
    }


}