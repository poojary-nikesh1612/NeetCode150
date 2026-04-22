package Stack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class ValidParentheses {
    public static boolean isValid(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        HashMap<Character,Character> closeToOpen=new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put('}','{');
        closeToOpen.put(']','[');

        for(char c:s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(!stack.isEmpty() && stack.peek()==closeToOpen.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(c);
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[]args){
        String s="()[]{}";
        System.out.println(isValid(s));
    }

}
