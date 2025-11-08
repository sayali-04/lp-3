public class FractionKnapsack {
    public static void main(String[] args) {
        int n = 4;                      // number of items
        int[] value = {40, 100, 50, 60};   // values of items
        int[] weight = {20, 10, 40, 30};    // weights of items
        int capacity = 60;              // knapsack capacity

        double[] ratio = new double[n]; // value/weight ratio
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) value[i] / weight[i];
        }

        // sort items by ratio (descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    // swap value
                    int tempV = value[i];
                    value[i] = value[j];
                    value[j] = tempV;
                    // swap weight
                    int tempW = weight[i];
                    weight[i] = weight[j];
                    weight[j] = tempW;
                    // swap ratio
                    double tempR = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempR;
                }
            }
        }

        double totalValue = 0.0;
        int currentWeight = 0;

        // greedy selection
        for (int i = 0; i < n; i++) {
            if (currentWeight + weight[i] <= capacity) {
                currentWeight += weight[i];
                totalValue += value[i];
            } else {
                int remain = capacity - currentWeight;
                totalValue += value[i] * ((double) remain / weight[i]);
                break;
            }
        }

        System.out.println("Maximum value in knapsack = " + totalValue);
    }
}
