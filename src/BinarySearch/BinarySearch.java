package BinarySearch;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(right-left)/2+left;
            if(target==nums[mid])
                return mid;
            else if (target<nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        int[] nums={-1,0,3,5,9,12};
        System.out.println(search(nums,19));
    }
}
