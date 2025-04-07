public class OneSegment{
    public static boolean checkOnesSegment(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // A new segment of '1's starts
            if (str.charAt(i) == '1' && (i == 0 || str.charAt(i - 1) == '0')) {
                count++;
                if (count > 1) {
                    return false; // More than one segment
                }
            }
        }

        return true; // At most one segment of '1's
    }

    public static void main(String[] args) {
        String str = "110"; // Change input to test
        boolean result = checkOnesSegment(str);
        System.out.println("Valid segment: " + result);
    }
}
