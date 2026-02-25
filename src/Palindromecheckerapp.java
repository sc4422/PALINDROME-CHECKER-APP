import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;


public class Palindromecheckerapp {

    public static boolean isPalindrome(String input) {

        // 1. Normalize string: remove spaces using regex & convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // 2. Convert to char array
        char[] arr = normalized.toCharArray();

        // 3. Check palindrome using two-pointer approach
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPalindrome(str)) {
            System.out.println("Palindrome (ignoring spaces & case)");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}