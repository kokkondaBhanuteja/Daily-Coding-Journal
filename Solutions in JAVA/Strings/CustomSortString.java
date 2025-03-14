import java.util.*;

public class CustomSortString {
    public static String specificOrder(String x, String y) {
        Map<Character, Integer> mp = new HashMap<>();
        
        // Count occurrences of characters in x
        for (char ch : x.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Append characters of x in order of y
        for (char ch : y.toCharArray()) {
            if (mp.containsKey(ch)) {
                sb.append(String.valueOf(ch).repeat(mp.get(ch))); // Append multiple occurrences
                mp.remove(ch); // Remove after processing
            }
        }
        
        // Append remaining characters in original order of x and not existing in y
        for (char ch : x.toCharArray()) {
            if (mp.containsKey(ch)) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter string x: ");
        String x = scanner.nextLine();
        
        System.out.print("Enter string y: ");
        String y = scanner.nextLine();
        
        String result = specificOrder(x, y);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
