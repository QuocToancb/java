import java.io.*;

class GFG
{
	// Function that print all combinations of
	// balanced parentheses
	// open store the count of opening parenthesis
	// close store the count of closing parenthesis
	static void _printParenthesis(char str[], int pos, int number, int open, int close)
	{
		if(close == number)
		{
			// print the possible combinations
			for(int i=0;i<str.length;i++)
				System.out.print(str[i]);
			System.out.println();
			return;
		}
		else
		{
			if(open > close) {
				str[pos] = '}';
				_printParenthesis(str, pos+1, number, open, close+1);
			}
			if(open < number) {
				str[pos] = '{';
				_printParenthesis(str, pos+1, number, open+1, close);
			}
		}
	}

	// Wrapper over _printParenthesis()
	static void printParenthesis(char str[], int number)
	{
		if(number > 0)
			_printParenthesis(str, 0, number, 0, 0);
	}

	// driver program
	public static void main (String[] args)
	{
		int n = 3;
		char[] str = new char[2 * n];
		printParenthesis(str, n);
	}
}
