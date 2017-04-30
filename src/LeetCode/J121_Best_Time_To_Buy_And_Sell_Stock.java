package LeetCode;

public class J121_Best_Time_To_Buy_And_Sell_Stock {

	public static void main(String[] args) {
		int[] input = { 2,1,2,1,0,1,2};
		int[] input1 = {7, 1, 5, 3, 6, 4};
		int [] input2 = {3,7,1,2};
		//System.out.println(maxProfit(input1));
		System.out.println(maxProfit1(input2));
	}
	
	 public static int maxProfit(int[] prices) {
	        if (prices.length == 0 || prices.length == 1) return 0;
	        int index = 0;
	        int maxProfit = 0;
	        
	        //[1,n]
	        for (int i = 1; i <= prices.length - 1; i++) {
	            if (prices[i - 1] >= prices[i]) {
	                index ++;
	            } else {
	                //[index + 1,n)
	                for (int j = index + 1; j < prices.length; j++) {
	                    maxProfit = Math.max(maxProfit, prices[j] - prices[index]);
	                }
	                index ++;
	            }
	        }
	        return maxProfit;
	    }
	 
	 public static int  maxProfit1(int[] prices) {       
		 if (prices.length == 0 || prices.length == 1) return 0;
		 int min = prices[0];
		 int maxProfit = 0;
		
		 for (int i = 1; i < prices.length; i++) {
		     if (prices[i] < min) {
		         min = prices[i];
		     } else {
		    	 maxProfit = Math.max(maxProfit, prices[i] - min);
		     }
		 }
	     return maxProfit;
	    }

}
