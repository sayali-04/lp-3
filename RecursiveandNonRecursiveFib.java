import java.util.*;

class RecursiveandNonRecursiveFib {

    // Recursive Fibonacci function
    static int rfibonacci(int n) {
        if (n <= 1)
            return n; // Base case
        return rfibonacci(n - 1) + rfibonacci(n - 2); 
    }

    // Non-Recursive (Iterative) Fibonacci function
    static void nRfibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.println("\nFibonacci series using iteration:");
        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt(); 

        System.out.println("\nFibonacci series using recursion:");
        for (int i = 0; i <= n; i++) {
            System.out.print(rfibonacci(i) + " ");
        }

        nRfibonacci(n);
        sc.close();
    }
}
