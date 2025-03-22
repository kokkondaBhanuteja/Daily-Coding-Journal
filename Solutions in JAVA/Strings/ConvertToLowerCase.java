public class ConvertToLowerCase {
	private static String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder(str.length()); // Initialize with known size
		for (int i = 0; i < str.length(); i++) {
			sb.append((char)(str.charAt(i) | 32)); // Bitwise OR to convert uppercase to lowercase
		}
		return sb.toString();
	}

    public static void main(String[] args) {
        System.out.println(toLowerCase("HeLLo WoRLD!")); // Output: hello world!
    }
}