package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder str=new StringBuilder();

        for(String s :strs){
            str.append(s.length());
            str.append("#");
            str.append(s);

        }
        return str.toString();
    }

    public static List<String> decode(String str) {
        List<String> strs=new ArrayList<>();
        int n=str.length();
        if(n<1)return strs;

        int i=0;
        while(i<n){
            int j=i;
            while(str.charAt(j)!='#')
                j++;

            int length=Integer.parseInt(str.substring(i,j));
            i=j+1;
            strs.add(str.substring(i,i+length));
            i+=length;
        }
        return strs;
    }
    public static void main(String[]args){
        List<String> list = new ArrayList<>(Arrays.asList("Hello","World"));
        String str=encode(list);
        List<String> ans=decode(str);
        System.out.println(ans);

    }

}
