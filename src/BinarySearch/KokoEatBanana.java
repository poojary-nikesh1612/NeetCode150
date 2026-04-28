package BinarySearch;

import java.util.Arrays;

public class KokoEatBanana {
    public static int getEatingHour(int[]piles,int speed,int h){
        int totalHour=0;
        for(int bananas:piles){
            totalHour+=(bananas+speed-1)/speed;
            if(totalHour>h)break;
        }
        return totalHour;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high= Arrays.stream(piles).max().getAsInt();
        int k=high;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(getEatingHour(piles,mid,h)<=h){
                k=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return k;
    }

    public static void main(String[]args){
        int[]piles={3,6,7,11};
        System.out.println(minEatingSpeed(piles,8));
    }
}
