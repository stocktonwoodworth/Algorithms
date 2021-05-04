import java.util.Arrays;
import java.util.Collections;

public class BinPacking {

    /**
     * Use a greedy approach to find the min
     * number of bins.
     *
     * @param W - array containing weight of items
     * @param C - max capacity for bins
     */
    private static int minBinsGreedy(Integer[] W, int C) {

        int minBins = 0; // arbitrary starting min
        int[] allBins = new int[W.length]; // Max number of bins possible is the number of items
        Arrays.sort(W, Collections.reverseOrder()); // Sort array in descending order T(n) = O(nlogn)


        for (Integer integer : W) {
            int j;
            for (j = 0; j < minBins; j++) {
                if (allBins[j] >= integer) {
                    allBins[j] = allBins[j] - integer;
                    break;
                }
            }

            // If no bin could accommodate weight[i]
            if (j == minBins) {
                allBins[minBins] = C - integer;
                minBins++;
            }
            System.out.println("Updated allBins: " + Arrays.toString(allBins));
        }
        System.out.println("Final allBins: " + Arrays.toString(allBins));
        return minBins;
    }

    public static void main(String[] args) {

        Integer[] array = {2, 5, 4, 7, 1, 3, 8};
        int min;

        min = minBinsGreedy(array, 10);

        System.out.println("Minimum number of bins needed for " + Arrays.toString(array) + " is " + min);
    }
}
