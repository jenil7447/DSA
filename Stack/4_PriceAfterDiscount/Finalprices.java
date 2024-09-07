/// 2 nd approch 
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
          
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];  
            }
            
          
            stack.push(i);
        }
        
        return prices;
    }
}
//// 1 st aprroch
class Solution {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i] ) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}

//////////
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i < prices.length ; i++){
           stack.push(i);
           if(stack.peek() >= prices[i+1]){
           prices[i] = prices[i] - prices[i+1];
           }
            
        }
        return prices;
}
