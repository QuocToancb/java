import java.util.Stack;

public class CheckBrace {
	public static void main(String[] args) {
		Stack<Character> stack =  new Stack();
		String input = "){})";
		boolean response = true;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '{' || c == '(') {
				stack.push(c);
			} else {
				if( c == '}') {
					if(stack.isEmpty() || stack.pop() != '{'){
						response = false;
						break;
					}
				}
				if( c == ')') {
					if(stack.isEmpty() || stack.pop() != '('){
						response = false;
						break;
					}
				}
			}
		}

		System.out.println(response);
	}
}
