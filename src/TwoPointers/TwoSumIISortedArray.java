package TwoPointers;

public class TwoSumIISortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;

        while(l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                return new int[] {l+1,r+1};
            }
            if(sum>target)
                r--;
            else
                l++;
        }
        return new int[0];
    }
    public static void main(String[]args){
        int[] arr={2,7,11,15};
        int[] ans=twoSum(arr,9);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
