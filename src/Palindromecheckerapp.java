import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;


public class Palindromecheckerapp {
    private String normalize(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // public method exposed to user
    public boolean checkPalindrome(String input) {

        String normalized = normalize(input);
        Stack<Character> stack = new Stack<>();

        // push characters into stack
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        // compare while popping
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Palindromecheckerapp checker = new Palindromecheckerapp();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("Palindrome ✔");
        } else {
            System.out.println("Not a palindrome ✘");
        }

        sc.close();
    }
}