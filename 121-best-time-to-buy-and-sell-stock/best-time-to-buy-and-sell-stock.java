class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int minprice=Integer.MAX_VALUE;
        for(int price:prices){
            if(price < minprice){
                minprice=price;
            }
            else{
                int profit=price-minprice;
                maxprofit=Math.max(maxprofit,profit);
            }
        }
        return maxprofit;
        
    }
}