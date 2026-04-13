package TwoPointers;

public class IsStringPalindrome {

    //uisng reverse,  TC->O(n), SC->O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder str=new StringBuilder();

        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                str.append(Character.toLowerCase(c));
            }
        }
        return str.toString().contentEquals(str.reverse());
    }

    //using two pointer without any extra space, TC->O(n), SC->O(1)
    public static boolean isPalindrome1(String s) {
        int n=s.length();
        int l=0;
        int r=n-1;

        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[]args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
