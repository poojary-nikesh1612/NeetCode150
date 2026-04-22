package Stack;

import java.util.ArrayDeque;

public class EvaluateRPN {
    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack=new ArrayDeque<>();

        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int opr2=stack.pop();
                int opr1=stack.pop();
                int ans=0;
                switch(s){
                    case "+":
                        ans=opr1+opr2;
                        break;
                    case "-":
                        ans=opr1-opr2;
                        break;
                    case "*":
                        ans=opr1*opr2;
                        break;
                    case "/":
                        ans=opr1/opr2;
                        break;
                }
                stack.push(ans);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.poll();
    }

    public static void main(String[]args){
        String[] arr={"2","1","+","3","*"};
        System.out.println(evalRPN(arr));
    }
}
