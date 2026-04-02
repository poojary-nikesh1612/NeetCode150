package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int longest=1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))continue;
            int cnt=map.getOrDefault(nums[i]-1,0)+map.getOrDefault(nums[i]+1,0)+1;

            map.put(nums[i],cnt);
            map.put(nums[i]-map.getOrDefault(nums[i]-1,0),cnt);
            map.put(nums[i]+map.getOrDefault(nums[i]+1,0),cnt);
            longest=Math.max(longest,cnt);
        }
        return longest;
    }

    public static void main(String[]args){
        int[]arr={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
}
}
