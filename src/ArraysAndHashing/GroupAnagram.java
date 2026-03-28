package ArraysAndHashing;

import java.util.*;

public class GroupAnagram {
    public static String charFreq(String s){
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        return Arrays.toString(freq);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            String freq=charFreq(s);

            map.computeIfAbsent(freq,k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[]args){
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
