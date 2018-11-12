class BestTime2BuyAndSellStock_121{
	public int maxProfit(int[] prices) {
        int max = 0, maxProfit = 0;
        for(int i = prices.length - 1; i >= 0; --i){
            if(max - prices[i] > maxProfit) maxProfit = max - prices[i];
            if(prices[i] > max) max = prices[i];
        }
        return maxProfit;
    }
}