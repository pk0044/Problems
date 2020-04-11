package com.pk.Problems;
class Solution {
    public int maxProfit(int[] prices) {

        int buy = -1;
        int sell = -1;
        int size = prices.length;
        
        if(size <= 1){
            return 0;
        }
        
        
        
        
        if(prices.length > 1 &&  prices[0] < prices[1]){
            buy = 0;
        }else if(prices[0] == prices[1]){
            int flag = 0;
            int j = 0;
            while(j < size-1){
                if(prices[j] == prices[j+1]){
                    j++;
                }else{
                    flag = 1;
                    break;
                }
                
            }
            
            if(flag == 0 && prices[size-2] == prices[size-1]){
                return 0;
            }
            
            if(prices[j] < prices[j+1]){
                buy = j;
            }
        }
        
        int i = 1;
        int profit = 0;
        
        int dir = -1;
        while(i < prices.length-1){
            if(prices[i] < prices[i+1]){
                dir = 1;
            }else if(prices[i] > prices[i+1]){
                dir = -1;
            }
            if(prices[i] > prices[i-1] && prices[i] > prices[i+1]){
                profit = profit + prices[i] - prices[buy];
            }
            
            if(prices[i] < prices[i-1] && prices[i] < prices[i+1] || (dir == -1 && prices[i] == prices[i-1] && prices[i] < prices[i+1])){
                buy = i;
            }
            i++;
        }
        
    
        if(prices[size-1] > prices[size-2]){
            profit = profit + prices[size-1] - prices[buy];
        }
        
        return profit;
    }
}