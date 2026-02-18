import java.util.Scanner;

public class Palindromecheckerapp {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String rev = "";

        // iterate from last character
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equalsIgnoreCase(rev))
            System.out.println("Palindrome string");
        else
            System.out.println("Not a palindrome string");
            }
        }

