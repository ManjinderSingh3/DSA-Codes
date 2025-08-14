import java.util.Stack;
public class e_ReversePolishNotation {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i<tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int topElement = stack.pop();
                int secondTopElement = stack.pop();
                switch (tokens[i]) {
                    case "+" -> stack.push(secondTopElement + topElement);
                    case "-" -> stack.push(secondTopElement - topElement);
                    case "*" -> stack.push(secondTopElement * topElement);
                    case "/" -> stack.push(secondTopElement / topElement);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        e_ReversePolishNotation rpnEvaluator = new e_ReversePolishNotation();

        // Example: (2 + 1) * 3 = 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result 1: " + rpnEvaluator.evalRPN(tokens1)); // Output: 9

        // Example: 4 + (13 / 5) = 6
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result 2: " + rpnEvaluator.evalRPN(tokens2)); // Output: 6

        // Example: (10 * (6 / ((9 + 3) * -11))) + 17 + 5 = 22
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Result 3: " + rpnEvaluator.evalRPN(tokens3)); // Output: 22
    }
}
