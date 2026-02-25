import java.util.*;


public class Palindromecheckerapp {

        // ---------- Normalization ----------
        private static String normalize(String input) {
            return input.replaceAll("\\s+", "").toLowerCase();
        }

        // ---------- Algorithm 1: Two Pointer ----------
        private static boolean twoPointer(String input) {
            String s = normalize(input);
            int l = 0, r = s.length() - 1;

            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++; r--;
            }
            return true;
        }

        // ---------- Algorithm 2: Stack ----------
        private static boolean stackMethod(String input) {
            String s = normalize(input);
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) stack.push(c);
            for (char c : s.toCharArray())
                if (c != stack.pop()) return false;

            return true;
        }

        // ---------- Algorithm 3: Deque ----------
        private static boolean dequeMethod(String input) {
            String s = normalize(input);
            Deque<Character> dq = new ArrayDeque<>();

            for (char c : s.toCharArray()) dq.addLast(c);

            while (dq.size() > 1)
                if (!dq.removeFirst().equals(dq.removeLast()))
                    return false;

            return true;
        }

        // ---------- Benchmark Utility ----------
        private static long measureTime(Runnable algo) {
            long start = System.nanoTime();
            algo.run();
            long end = System.nanoTime();
            return end - start;
        }

        // ---------- Main ----------
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string to test: ");
            String input = sc.nextLine();

            System.out.println("\nRunning performance comparison...\n");

            long t1 = measureTime(() -> twoPointer(input));
            long t2 = measureTime(() -> stackMethod(input));
            long t3 = measureTime(() -> dequeMethod(input));

            System.out.println("Algorithm Performance (nanoseconds)");
            System.out.println("------------------------------------");
            System.out.println("Two Pointer : " + t1);
            System.out.println("Stack       : " + t2);
            System.out.println("Deque       : " + t3);

            sc.close();
        }
    }