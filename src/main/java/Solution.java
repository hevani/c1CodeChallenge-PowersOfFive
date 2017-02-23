public class Solution {
    public Solution(){
    }

    public synchronized int getMin (String s ){
		long [] n = new long [s.length() + 1] ;
		n[0] = 0;	
		for (int i = 1 ; i <= s.length() ;++i) {
			n[i] = Integer.MAX_VALUE;
			for(int j=i;j>=1;--j) {
			 if (s.charAt(j - 1) == '0'){
				 continue ;
			 }
			 long num = Long.parseLong(s.substring(j - 1, i), 2) ;				 
			 if (isPowerOfFive(num)) {
				 n[i] = Math.min(n[i], n[j - 1] + 1) ;				 
			 }			 
		 }
		}								
		return n[s.length()] == Integer.MAX_VALUE ? -1 : (int)n[s.length()] ;
	}
	
	private boolean isPowerOfFive(long val){
		if (val == 0) {
			return false ;  
		}
		int n = (int)(Math.log(val) / Math.log(5));
		return Math.pow(5, n) == val;
	}
}
