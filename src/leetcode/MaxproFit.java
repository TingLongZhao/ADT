package leetcode;

public class MaxproFit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1;i<prices.length;i++){
            int difference ;
            if(i==1){
                difference = prices[i]-prices[0];
            }else{
                difference = prices[i]-prices[i-1];
            }
            if(difference>=0){
                profit += difference;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arrys = {7,6,4,3,1};
        System.out.println(maxProfit(arrys));
    }
}
