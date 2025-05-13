import java.util.*;

public class PowerOfTwoReorder {
    
    public static boolean reorderedPowerOf2(int N) {
        String original = countDigits(N);
        
        for (int i = 0; i < 31; i++) {
            int powerOfTwo = 1 << i; // 2^i
            if (original.equals(countDigits(powerOfTwo))) {
                return true;
            }
        }
        return false;
    }

    private static String countDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }

    // Test
    public static void main(String[] args) {
        int N1 = 218;
        int N2 = 101;

        System.out.println(reorderedPowerOf2(N1)); // true
        System.out.println(reorderedPowerOf2(N2)); // false
    }
}
