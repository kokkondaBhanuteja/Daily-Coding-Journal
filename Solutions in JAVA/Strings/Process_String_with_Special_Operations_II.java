import java.util.Scanner;

class ProcessSolutionII {

    public char processStr(String s, long k) {
        long len = 0;
        for(Character ch: s.toCharArray()){
            if(Character.isLowerCase(ch)){
                len++;
            }
            else if(ch == '*'){
                if(len > 0){
                    len--;
                }
            }
            else if(ch == '#'){
                len*=2;
            }
        }
        if( k < 0 ||   k > len ){
            return '.';
        }

        for(int i= s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                if(k == len-1){
                    return ch;
                }
                len--;
            }
            else if(ch == '*'){
                len++;
            }
            else if(ch == '#'){
                long half = len/2;
                if(k >= half){
                    k-=half;
                }
                len = half;
            }
            else if( ch == '%'){
                k = len - 1 - k;
            }
        }
        return '.';
    }
}

public class Process_String_with_Special_Operations_II {
    public static void main(String[] args) {
        ProcessSolutionII solution = new ProcessSolutionII();
        String s = "a#b%*";
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the position k: ");
        long k = scanner.nextLong();

        char result = solution.processStr(s, k);

        System.out.println("The character at position " + k + " is: " + result);
    }
}
