import java.util.*;
public class CheckValidityOfPassword{
	public static boolean isValid(String str) {
		 int n = str.length();
		 if ( n < 8 || n > 15){
			 return false;
		 } 
		 boolean hasDigit= false, hasLower = false, hasUpper = false, hasSpecial = false, notSpace = true;
		 Set<Character> specialCharacters= new HashSet<>(Arrays.asList(',','\\','|','"','?','>','!','@','#','$','%','^','&','*','-','_','+','=','{','}','(',')','[',']',',','\''));
		 
		 for(Character ch : str.toCharArray()){
			if(Character.isDigit(ch))hasDigit = true;
			else if(Character.isUpperCase(ch)) hasUpper = true;
			else if(Character.isLowerCase(ch)) hasLower = true;
			else if(Character.isWhitespace(ch)) notSpace = false;
			else if(specialCharacters.contains(ch)) hasSpecial = true;
		}
		return hasDigit && hasLower && hasUpper&& hasSpecial && notSpace;
	}
	public static void main(String []args){
		System.out.println(isValid("HEllo@World#0"));
	}
}