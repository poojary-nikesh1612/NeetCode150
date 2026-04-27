package Stack;

public class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prevSmaller=new int[n];
        int[] nextSmaller=new int[n];
        int maxArea=0;

        prevSmaller[0]=-1;
        nextSmaller[n-1]=n;

        for(int i=1;i<n;i++){
            int left=i-1;
            while(left>=0 && heights[left]>=heights[i]){
                left=prevSmaller[left];
            }
            prevSmaller[i]=left;
        }

        for(int i=n-2;i>=0;i--){
            int right=i+1;
            while(right<n && heights[right]>=heights[i]){
                right=nextSmaller[right];
            }
            nextSmaller[i]=right;
        }

        for(int i=0;i<n;i++){
            int left=i-prevSmaller[i];
            int right=nextSmaller[i]-i;
            maxArea= Math.max(maxArea,(left+right-1)*heights[i]);
        }
        return maxArea;
    }

    public static void main(String[]args){
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
