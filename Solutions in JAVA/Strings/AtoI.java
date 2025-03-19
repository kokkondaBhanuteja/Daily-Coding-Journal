import java.util.*;
import java.lang.*;
class AtoI{
    public static int convert(String s) {
        int i=0;
        int n = s.length();
        int sign =1;
        while(s.charAt(i)== ' ')i++;
        if(i<n && s.charAt(i) =='+')i++;
        else if(i<n && s.charAt(i) == '-'){
            sign = -1;i++;
        }
        int num = 0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && s.charAt(i)=='7'){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            num = num*10 + (s.charAt(i)-'0');
            i++;
        }
        return num*sign;
    }
	public static void main(String[] args){
		String s = "-123";
		System.out.println(convert(s));
	}
}