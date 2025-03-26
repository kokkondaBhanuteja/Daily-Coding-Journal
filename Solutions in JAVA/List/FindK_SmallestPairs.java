import java.util.*;
import java.util.*;
public class FindK_SmallestPairs {
    public static ArrayList<ArrayList<Integer>> findPairs(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<int[]> pairs = new ArrayList<>();

        // Generating all pairs
        for (int x : arr1) {
            for (int y : arr2) {
                pairs.add(new int[]{x, y});
            }
        }

        // Sorting pairs based on sum of elements
        pairs.sort(Comparator.comparingInt(pair -> pair[0] + pair[1]));

        // Extract the first 'k' smallest pairs
        int i = 0;
        while (i < k && i < pairs.size()) { // Ensure 'i' doesn't exceed the number of pairs
            int[] pair = pairs.get(i);
            ans.add(new ArrayList<>(Arrays.asList(pair[0], pair[1])));
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Input arrays
        int n = 3, m = 3, k = 3;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 6));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 3, 5));

        // Finding K smallest pairs
        ArrayList<ArrayList<Integer>> result = findPairs(n, m, arr1, arr2, k);

        // Output the result
        System.out.println("K smallest pairs with smallest sum:");
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
