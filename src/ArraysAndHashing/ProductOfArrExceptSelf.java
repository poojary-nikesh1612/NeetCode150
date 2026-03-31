package ArraysAndHashing;

public class ProductOfArrExceptSelf {

    //better approach using 2 arrays prefix and suffix with TC->O(n) & SC->O(n)
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int[] ans=new int[n];
        prefix[0]=1;
        suffix[n-1]=1;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
            suffix[n-1-i]=suffix[n-i]*nums[n-i];
        }

        for(int i=0;i<n;i++){
            if(i==0)
                ans[0]=suffix[0];
            else if (i==n-1)
                ans[n-1]=prefix[n-1];
            else
                ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }

    //Optimal with SC->O(1), not used any extra arrays except ans array, TC->O(n)
    public static int[] productExceptSelf1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        ans[0]=1;

        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }

        int suffix=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=suffix;
            suffix*=nums[i];
        }
        return ans;
    }

    public static void main(String[]args){
        int[] arr={1,2,3,4};
        int[] ans=productExceptSelf1(arr);
        for (int num:ans){
            System.out.print(num+" ");
        }
    }
}
