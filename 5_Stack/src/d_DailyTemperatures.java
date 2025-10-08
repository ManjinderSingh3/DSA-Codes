import java.util.Stack;

public class d_DailyTemperatures {

    class Node{
        int value;
        int index;

        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Node> stack = new Stack<Node>();

        for (int i = 0; i < temperatures.length; i++) {
            Node newNode = new Node(temperatures[i], i);

            if (!stack.isEmpty() && newNode.value > stack.peek().value) {

                while (newNode.value > stack.peek().value) {
                    result[stack.peek().index] = newNode.index - stack.peek().index;
                    stack.pop();

                }
                stack.push(newNode);

            } else {
                stack.push(newNode);
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}


