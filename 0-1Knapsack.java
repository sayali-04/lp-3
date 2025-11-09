import java.util.Scanner;

public class DP_FractionKnapsack {
    public static int knapsack(int[] value, int[] weight, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][capacity]; // Maximum value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter the values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        System.out.println("Enter the weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int maxValue = knapsack(value, weight, capacity, n);
        System.out.println("\nMaximum value in 0/1 Knapsack = " + maxValue);

        sc.close();
    }
}
