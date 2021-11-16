
import java.util.*;
import java.io.*;

class Main {

	public static String CodelandUsernameValidation(String str) {
		if(str == null) return "false";
		if(checkLenghth1(str) && isLetter(str.charAt(0)) && !isUnderScore(str.charAt(str.length()-1)) && check2(str)) {
			return "true";
		} else {
			return "false";
		}
	}

	public static boolean startLetter(String str) {
		char c = str.charAt(0);
		return isLetter(c);
	}

	public static boolean check2(String str) {
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (isLetter(currentChar) || isNumber(currentChar) || isUnderScore(currentChar)){

			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isLetter(char c) {
		if((c>= 'a' && c <= 'z') ||
				(c >= 'A' && c<='Z') ||
				(c >= 1 && c<=9)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNumber(char c) {
		try{
			Double.parseDouble(String.valueOf(c));
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public static boolean checkLenghth1(String str) {
		if (str == null) return false;
		if(str.length() >4 && str.length() <25) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isUnderScore(char c) {
		return String.valueOf(c).equalsIgnoreCase("_");
	}

	public static void main (String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(CodelandUsernameValidation(s.nextLine()));

		"a".matches("[a-zA-Z]");
	}

}