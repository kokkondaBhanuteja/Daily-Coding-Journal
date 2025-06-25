import java.util.* ;
import java.io.*; 
public class StrobogramaticNum{
   
   	public static boolean isStrobogrammatic(String n){
		   int start = 0;
		   int end = n.length()-1;
		   while(start<=end){
			   char s1 = n.charAt(start);
			   char e1 = n.charAt(end);
			   if(s1 == e1 && (s1== '1' || s1 =='8' || s1=='0')){
				   start++;
				   end--;
			   }else if(s1 =='6'&& e1=='9' || s1=='9'&& e1=='6'){
				   start++;
				   end--;
			   }else{
				   return false;
			   }
		   }
		return true;
    }
    	public static void main(String args[]){
		String num = "191";
		System.out.println(isStrobogrammatic(num));
	}	

}