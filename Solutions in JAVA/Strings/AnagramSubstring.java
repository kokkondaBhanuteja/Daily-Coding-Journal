import java.util.Set;

public class AnagramSubstring {
    private static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right) ){
                return false;
            }
        }
        return true;
    }
    private static boolean isPossible(String str){
        Set<Character> set = Set.of('A', 'H', 'I','M', 'O','T','U','V','W','X','Y');
        boolean isThere = true;
        for(char ch: str.toCharArray()){
            if(!set.contains(ch)){
                isThere = false;
                break;
            }
        }
        return (isThere && isPalindrome(str));
    }
    public static void main(String[] args) {
        String str = "AMMA";
        System.out.println(isPossible(str));
    } 
}
