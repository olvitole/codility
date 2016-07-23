package crackingthecoding;

public class MinimumElementInRotatedSortedArray {
	
	
	
	
	
	public static void main(String args[]){
		
		int[] arr = {4,5,6,7,1,2};
		
		System.out.println("Min is: " + findMin(arr));
		
	}
	
	
	private static int findMin(int[] arr){
				
		int size = arr.length;
		if (size >0) {
		
			int min = arr[0];
			int max = arr[size];
			int mid = -1;
		
			// applyRules(new MinMax(min,max));
		
		}
		
		
		return -1;
		
	}
	
	private static MinMax applyRules(MinMax in, int[] arr){
		
		int min = in.min;
		int max = in.max;
		
		// it is sorted 
		if (min<max){
		} else {
			
		}
		
		return in;
		
	}
	
	class MinMax {
		
		public MinMax(int min, int max){
			this.min = min;
			this.max = max;
		}
		
		public int min;
		public int max;
	}
	
	
	

}
