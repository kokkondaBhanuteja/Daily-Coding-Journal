public class addBinaryString {
    public static String addString(String a, String b, int n, int m) {
        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        int j = m - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append((char) ((sum % 2) + '0'));
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1101";
        String b = "1011";
        int n = a.length();
        int m = b.length();

        String result = addString(a, b, n, m);
        System.out.println("Sum of binary strings: " + result);  // Output: 11000
    }
}
