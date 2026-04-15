package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int longestLength=0;
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        for(int r=0;r<n;r++){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(map.get(s.charAt(r))+1,l);
            }

            map.put(s.charAt(r),r);
            longestLength=Math.max(longestLength,r-l+1);

        }
        return longestLength;
    }

    public static void main(String[]args){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
