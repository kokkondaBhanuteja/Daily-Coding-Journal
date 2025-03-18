import java.util.*;

public class  Longest_Substring_With_K_Distinct_Characters
 {
    public static int getLengthofLongestSubstring(String s, int k) {
        if (k == 0) return 0; // Edge case: No distinct characters allowed
        
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        int j = 0; // Start pointer of the sliding window

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);

            while (mp.size() > k) { // Shrink the window
                mp.put(s.charAt(j), mp.get(s.charAt(j)) - 1);
                if (mp.get(s.charAt(j)) == 0) {
                    mp.remove(s.charAt(j));
                }
                j++; // Move left pointer forward
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(getLengthofLongestSubstring(s, k)); // Expected Output: 7 ("cbebebe")
    }
}
