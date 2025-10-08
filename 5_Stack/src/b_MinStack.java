import java.util.Stack;
public class b_MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public b_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            minStack.push(val);
            return;
        }
        stack.push(val);
        if( val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int poppedValue = stack.pop();
        if(poppedValue == minStack.peek()){
            minStack.pop();
        }

    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}

