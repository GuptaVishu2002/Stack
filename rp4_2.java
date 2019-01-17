import java.util.*;

public class rp4_2 {
    private static Stack<Double> stack = new Stack<Double>();
    private static Scanner input = new Scanner(System.in);

    private static void input(String result) throws Exception {

        for (String token : result.split("\\s+")) {
            System.out.print("Input " + token + "\n");
            switch (token) {
                case "+":
                    System.out.print("Operation "+"Add\n");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    System.out.print("Operation "+"Subtract\n");
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    System.out.print("Operation "+"Multiply\n");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    System.out.print("Operation "+"Divide\n");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    System.out.print("Operation "+"Operate\n");
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                default:
                    System.out.print("Operation "+"Push\n");
                    stack.push(Double.parseDouble(token));
                    break;
            }

            System.out.println("Stack "+ stack + "\n");
        }

        System.out.println("Answer: " + stack.pop());
    }


	public static String change(String input) {
		if (input == null)
		    return "";
		char[] in = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < in.length; i++)
        switch (in[i]) {
        case '+':
        case '-':
            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                out.append(' ');
                out.append(stack.pop());
            }
            out.append(' ');
            stack.push(in[i]);
            break;
        case '*':
        case '/':
            out.append(' ');
            stack.push(in[i]);
            break;
        case '(':
            stack.push(in[i]);
            break;
        case ')':
            while (!stack.empty() && stack.peek() != '(') {
                out.append(' ');
                out.append(stack.pop());
            }
            stack.pop();
            break;
        default:
            out.append(in[i]);
            break;
        }

		while (!stack.isEmpty())
		    out.append(' ').append(stack.pop());

		return out.toString();
	}

    public static void main(String[] args) {
        try {
        		String op;
        		System.out.println("Enter input: ");
        		op = input.nextLine();
            	String result = change(op);
            	System.out.println("\nReverse Polish Notation is: ");
            	System.out.println(result +"\n");
            	input(result);
        } catch (Exception e) {

        }

    }
}
