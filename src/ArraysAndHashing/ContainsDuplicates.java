package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hash=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i]))
                return true;
            else
                hash.add(nums[i]);
        }
        return false;
    }

    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6};
        System.out.println(containsDuplicate(arr));
    }
}
