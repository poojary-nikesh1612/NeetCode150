package TwoPointers;

public class MostWaterContainer {
    public static int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int l=0;
        int r=height.length-1;

        while(l<r){
            int min=Math.min(height[l],height[r]);
            max=Math.max(max,min*(r-l));

            if(height[l]<height[r])
                l++;
            else
                r--;
            /* this is the little more optimised in speed skipping multiple useless elements at once,
            but TC same O(n)
            while(l<r && height[l]<=min)l++;
            while(l<r && height[r]<=min)r--

             */

        }
        return max;
    }

    public static void main(String[]args){
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
