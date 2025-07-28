import java.util.ArrayList;
import java.util.List;

public class Stack_Implementation {
    List<Integer> stack;

    public Stack_Implementation(){
        stack = new ArrayList<Integer>();
    }

    public int peek(){
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public void push(int element){
        stack.add(element);
    }

    public int pop(){
        return stack.remove(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }

    public static void main(String[] args) {
        Stack_Implementation stackImplementation = new Stack_Implementation();
        stackImplementation.push(100);
        stackImplementation.push(200);
        stackImplementation.push(300);

        System.out.println(stackImplementation.peek());
        System.out.println(stackImplementation.pop());
        System.out.println(stackImplementation.peek());
    }
}
