package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que = new ArrayDeque<>();
        int[] ans= new int[nums.length-k+1];
        int l=0;

        for(int r=0;r<nums.length;r++){
            while(!que.isEmpty() && nums[que.getLast()]<nums[r]){
                que.removeLast();
            }
            que.addLast(r);

            if(que.getFirst()<l){
                que.removeFirst();
            }

            if((r+1)>=k){
                ans[l]=nums[que.getFirst()];
                l++;
            }
        }
        return ans;
    }

    public static void main(String[]args){
        int[] arr={1,3,-1,-3,5,3,6,7};
        int[] ans=maxSlidingWindow(arr,3);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}
