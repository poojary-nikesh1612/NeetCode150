package TwoPointers;

import java.util.ArrayDeque;

public class TrappingRainWater {
    // approach using prefix and suffix arrays, TC->O(n) & SC->O(n)
    public static int trap1(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        int res=0;

        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            res+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return res;

    }

    //approach used stack, TC->O(n) & SC->O(n)
    public static int trap2(int[] height) {
        int n=height.length;
        int res=0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int curBar=height[stack.pop()];
                if(!stack.isEmpty()){
                    int h=Math.min(height[stack.peek()],height[i])-curBar;
                    int w=i-stack.peek()-1;
                    res+=h*w;
                }
            }
            stack.push(i);
        }
        return res;
    }

    //approach used two pointers,TC->O(n), SC->O(1)
    public static int trap3(int[] height) {
        int n=height.length;
        int res=0;
        int leftMax=height[0];
        int rightMax=height[n-1];
        int l=0;
        int r=n-1;

        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }
            else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        return res;
    }


    public static void main(String[]args){
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(arr));
    }
}
