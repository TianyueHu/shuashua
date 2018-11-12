class BestTime2BuyAndSellStock2_122{
	public int maxProfit(int[] prices) {
        int maxProfit = 0, max = 0, min = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i = prices.length - 1; i >= 0; --i){
            if(max - prices[i] > maxProfit){
                maxProfit = max - prices[i];
                min  = prices[i];
            }
            else if(max < prices[i]){
                if(maxProfit > 0){
                    sum += maxProfit;
                    maxProfit = 0;
                }
                max = prices[i];
            }
            else if(min < prices[i]){
                sum += maxProfit;
                maxProfit = 0;
                max = prices[i];
            }
            
        }
        return sum + maxProfit;
    }
}