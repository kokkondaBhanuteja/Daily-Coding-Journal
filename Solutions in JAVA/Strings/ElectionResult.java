import java.util.*;

public class ElectionResult {

	public static String electionResult(String voters) {
		int[] left = new int[voters.length()];
		int[] right = new int[voters.length()];

		int temp = Integer.MAX_VALUE -1000;
		
		for(int i=0;i<voters.length();i++){
			if(voters.charAt(i) == 'B'){
				temp = 0;
			}
			else{
				temp++;
			}

			left[i] = temp;
		}
		temp = Integer.MAX_VALUE-1000;
		for(int i= voters.length()-1; i>=0;i--){
			if(voters.charAt(i) == 'A'){
				temp = 0;
			}
			else{
				temp++;
			}
			right[i] = temp;
		}
		int aWins = 0;
		int bWins = 0;
		for(int i=0;i<voters.length();i++){
			if(left[i] > right[i]){
				aWins++;
			}
			else if(left[i] < right[i]){
				bWins++;
			}
		}

		if(aWins > bWins){
			return "A";
		}
		else if ( bWins > aWins){
			return "B";
		}
		return "Coalition";
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the voters' string
        System.out.print("Enter the voters' string: ");
        String voters = scanner.next();
        
        // Call the electionResult function
        String result = ElectionResult.electionResult(voters);
        
        // Print the result
        System.out.println("Election Result: " + result);
        
        scanner.close();
    }
}
