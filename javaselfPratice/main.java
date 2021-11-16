import java.util.*;
class Solution2{

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input=sc.next();
			//Complete the code
			System.out.println(check(input));
		}

	}

	private static boolean check(String input) {
		Stack<Character> characterStack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if(character == '(' || character == '{' || character == '['){
				characterStack.push(character);
			}

			if(character == ')') {
				if (characterStack.isEmpty() || characterStack.pop() != '('){
					return false;
				}
			} else if(character == '}') {
				if (characterStack.isEmpty() || characterStack.pop() != '{'){
					return false;
				}

			} else if(character == ']') {
				if (characterStack.isEmpty() || characterStack.pop() != ']'){
					return false;
				}
			}
		}
		if(!characterStack.isEmpty()) return false;
		return true;
	}
}



