package SlidingWindow;

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int max=0;
        int minPrice=prices[0];

        for(int i=1;i<prices.length;i++){
            if(minPrice<prices[i]){
                max=Math.max(max,prices[i]-minPrice);
            }else{
                minPrice=prices[i];
            }
        }
        return max;
    }

    public static void main(String[]args){
        int[] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
