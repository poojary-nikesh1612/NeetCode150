package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public  static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);


        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1])continue;
            int l=i+1;
            int r=nums.length-1;

            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];

                if(sum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1])l++;
                }
                else if(sum>0){
                    r--;
                }
                else{
                    l++;
                }


            }

        }
        return ans;
    }

    public static void main(String[]args){
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> ans=threeSum(nums);

        for(List<Integer> l:ans){
            System.out.print(l+" ");
        }
    }
}
