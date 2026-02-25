import java.util.*;


interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    // Stack Strategy
    class StackStrategy implements PalindromeStrategy {

        private String normalize(String input) {
            return input.replaceAll("\\s+", "").toLowerCase();
        }

        public boolean isPalindrome(String input) {

            String normalized = normalize(input);
            Stack<Character> stack = new Stack<>();

            for (char c : normalized.toCharArray()) {
                stack.push(c);
            }

            for (char c : normalized.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    // Deque Strategy
    class DequeStrategy implements PalindromeStrategy {

        private String normalize(String input) {
            return input.replaceAll("\\s+", "").toLowerCase();
        }

        public boolean isPalindrome(String input) {

            String normalized = normalize(input);
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : normalized.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }
            return true;
        }
    }

    // Main Application Class
    public class Palindromecheckerapp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Choose Palindrome Strategy:");
            System.out.println("1. Stack Based");
            System.out.println("2. Deque Based");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter string: ");
            String input = sc.nextLine();

            // Strategy injection at runtime
            PalindromeStrategy strategy;

            if (choice == 1) {
                strategy = new StackStrategy();
            } else {
                strategy = new DequeStrategy();
            }

            boolean result = strategy.isPalindrome(input);

            if (result) {
                System.out.println("Palindrome ");
            } else {
                System.out.println("Not a palindrome ");
            }

            sc.close();
        }
    }