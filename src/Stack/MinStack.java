package Stack;

import java.util.ArrayDeque;

public class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }

    public void pop() {
        int ele=stack.poll();
        if(!minStack.isEmpty() && minStack.peek()==ele){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
