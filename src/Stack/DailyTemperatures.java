package Stack;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int ind=stack.pop();
                ans[ind]=i-ind;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[]args){
        int[] arr={73,74,75,71,69,72,76,73};
        int[] ans=dailyTemperatures(arr);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}
