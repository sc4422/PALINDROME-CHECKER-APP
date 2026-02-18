import java.util.Scanner;

public class Palindromecheckerapp {
    public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter string: ");
                String s = sc.next();

                int n = s.length();
                boolean isPalindrome = true;

                for (int i = 0; i < n/2; i++) {
                    if (s.charAt(i) != s.charAt(n - 1 - i)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome)
                    System.out.println("Palindrome");
                else
                    System.out.println("Not Palindrome");

                sc.close();
            }
        }

