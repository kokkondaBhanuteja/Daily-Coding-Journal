import java.util.*;

public class IntervalIntersection {

    public static List<List<Integer>> getIntersection(int[][] interval1, int[][] interval2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < interval1.length && j < interval2.length) {
            int a_start = interval1[i][0], a_end = interval1[i][1];
            int b_start = interval2[j][0], b_end = interval2[j][1];

            int start = Math.max(a_start, b_start);
            int end = Math.min(a_end, b_end);

            if (start <= end) {
                ans.add(new ArrayList<>(Arrays.asList(start, end)));
            }

            if (a_end < b_end) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] interval1 = {{1, 3}, {5, 6}, {7, 9}};
        int[][] interval2 = {{2, 5}, {7, 8}};

        List<List<Integer>> result = get
			Intersection(interval1, interval2);

        System.out.println("Intersected Intervals:");
        for (List<Integer> interval : result) {
            System.out.println(interval);
        }
    }
}
