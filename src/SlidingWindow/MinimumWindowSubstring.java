package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(t.length()==0 || s.length()==0 || t.length()>s.length())return "";
        Map<Character,Integer> mapT=new HashMap<>();
        Map<Character,Integer> mapS=new HashMap<>();

        for(char c:t.toCharArray()){
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }

        int have=0;
        int need=mapT.size();
        int l=0;

        int[] res={-1,-1};
        int resLen=Integer.MAX_VALUE;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            mapS.put(c,mapS.getOrDefault(c,0)+1);

            if(mapT.containsKey(c) && mapT.get(c).equals(mapS.get(c))){
                have++;
            }

            while(need==have){
                if(resLen>(r-l+1)){
                    resLen=(r-l+1);
                    res[0]=l;
                    res[1]=r+1;
                }

                c=s.charAt(l);
                mapS.put(c,mapS.get(c)-1);
                if(mapT.containsKey(c) && mapT.get(c)>mapS.get(c)){
                    have--;
                }
                l++;

            }

        }

        return resLen==Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]);

    }

    public static void main(String[] args){
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }
}
