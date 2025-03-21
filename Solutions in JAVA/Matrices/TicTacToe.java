import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class TicTacToe {
	// here we will check for
	private static boolean isWinner(Character[][] mat, Character ch){
		for(int i=0;i<3;i++){
			if(mat[i][0] == ch && mat[i][1]==ch && mat[i][2]==ch) return true;
			if(mat[0][i] == ch && mat[1][i]==ch && mat[2][i]==ch)return true;
			// check for Empty Cells
		}
		return (mat[0][0] ==ch && mat[1][1] ==ch && mat[2][2] == ch)||
				(mat[0][2] ==ch && mat[1][1] ==ch && mat[2][0] == ch);
	}
	public static String ticTacToeWinner(ArrayList<ArrayList<Integer>> moves) {
		Character[][] mat = new Character[3][3];
		boolean flag = true;
		// player-1 X
		// player-2 O
		for(ArrayList<Integer> turns: moves){
			int r = turns.get(0);
			int c = turns.get(1);
			Character ch = flag?'X':'O';
			mat[r][c] = ch;
			flag = !flag; 
			
		}
		if(isWinner(mat,'X')){
			return "player1";
		}
		else if(isWinner(mat,'O')){
			return "player2";
		}
		return moves.size()<9? "uncertain":"draw";

	}
	public static void main(String []args){
		// Test Case 1: Player 1 (X) wins early
		ArrayList<ArrayList<Integer>> moves1 = new ArrayList<>();
		
		moves1.add(new ArrayList<>(Arrays.asList(0, 0))); // X
		moves1.add(new ArrayList<>(Arrays.asList(1, 1))); // O
		moves1.add(new ArrayList<>(Arrays.asList(0, 1))); // X
		moves1.add(new ArrayList<>(Arrays.asList(1, 0))); // O
		moves1.add(new ArrayList<>(Arrays.asList(0, 2))); // X wins
		System.out.println("Resukt is = " + ticTacToeWinner(moves1)); // Expected: "player1"

	}
}