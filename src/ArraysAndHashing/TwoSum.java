package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i])){
                return new int[] {hash.get(target-nums[i]),i};
            }
            else{
                hash.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[]args){
        int[]arr={3,4,5,6};
        int target=7;

        int[] ans=twoSum(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
