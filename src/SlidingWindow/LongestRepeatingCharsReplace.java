package SlidingWindow;

public class LongestRepeatingCharsReplace {
    public static int characterReplacement(String s, int k) {
        int res=0;
        int[] cnt=new int[26];
        int maxF=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            cnt[s.charAt(r)-'A']++;
            maxF=Math.max(maxF,cnt[s.charAt(r)-'A']);


            while((r-l+1)-maxF>k){
                cnt[s.charAt(l)-'A']--;
                l++;
            }
            res=Math.max(res,(r-l+1));
        }
        return res;
    }

    public static void main(String[]args){
        String s="AABABBA";
        System.out.println(characterReplacement("AABABBA",1));
    }
}
