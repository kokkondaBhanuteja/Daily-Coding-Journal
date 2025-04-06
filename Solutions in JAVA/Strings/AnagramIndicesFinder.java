import java.util.*;

public class AnagramIndicesFinder {

    private static boolean areSame(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }

    public static List<Integer> findAnagramIndices(String STR, String PTR) {
        List<Integer> result = new ArrayList<>();

        int lenStr = STR.length();
        int lenPtr = PTR.length();

        if (lenPtr > lenStr) return result;

        int[] ptrCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < lenPtr; i++) {
            ptrCount[PTR.charAt(i) - 'a']++;
            windowCount[STR.charAt(i) - 'a']++;
        }

        if (areSame(ptrCount, windowCount)) {
            result.add(0);
        }

        for (int i = lenPtr; i < lenStr; i++) {
            windowCount[STR.charAt(i - lenPtr) - 'a']--; // remove left char
            windowCount[STR.charAt(i) - 'a']++; // add right char

            if (areSame(ptrCount, windowCount)) {
                result.add(i - lenPtr + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String STR = "cbaebabacd";
        String PTR = "abc";

        List<Integer> indices = findAnagramIndices(STR, PTR);
        for (int index : indices) {
            System.out.println("Anagram found at index: " + index);
        }
    }
}
