package SlidingWindow;

public class PermutationString {
    public static boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n)return false;

        int[] s1Freq=new int[26];
        int[] s2Freq=new int[26];
        int match=0;

        for(int i=0;i<m;i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(s1Freq[i]==s2Freq[i])
                match++;
        }

        int l=0;
        for(int r=m;r<n;r++){
            if(match==26) return true;

            int ind=s2.charAt(r)-'a';
            s2Freq[ind]++;
            if(s1Freq[ind]==s2Freq[ind])
                match++;
            else if(s1Freq[ind]+1==s2Freq[ind])
                match--;

            ind=s2.charAt(l)-'a';
            s2Freq[ind]--;
            if(s1Freq[ind]==s2Freq[ind])
                match++;
            else if(s1Freq[ind]-1==s2Freq[ind])
                match--;
            l++;


        }
        return match==26;
    }

    public static void main(String[]args){
        String s1="ab";
        String s2="eidboaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
