/**
 * This is a java Program of TIC-TAC-TOE Game played By the User and the Computer.
   _   _   _   _   _   _   _   _   _   _   _  
 / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ 
( T | i | c | - | T | a | c | - | T | o | e )
 \_/ \_/ \_/ \_/ \_/ \_/ \_/ \_/ \_/ \_/ \_/ 
 * @author Bhanu
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
public class Tic_Tac_Toe {
	static Scanner in = new Scanner(System.in);
	static List<Integer> Playerposition = new ArrayList<Integer>();
	static List<Integer> CPU_position = new ArrayList<Integer>();
	
	public static void main(String [] args) {
		char gameboard[][] = {{' ', '|', ' ','|' , ' '},
							  {'_', '+', '_','+' , '_' },
							  {' ', '|', ' ', '|' , ' '},
							  {'_', '+', '_','+' , '_'},
							  {' ', '|', ' ', '|' ,' '}};
		printboard(gameboard);
		
		while(true) {
			 Scanner in = new Scanner(System.in);
			System.out.println("Enter Your PIECE: ");
			int PlayerPos = in.nextInt();
			while(Playerposition.contains(PlayerPos) ||  CPU_position.contains(PlayerPos)) {
				System.out.println("Position already Taken , Try Again");
				PlayerPos = in.nextInt();
			}
			
			Item_placement(gameboard,PlayerPos,"player");
			String victory = Gamecheck();
			if(victory.length() > 0) {
				System.out.println(victory);
				break;
			}
			Random rand = new Random();
			int CpuPos = rand.nextInt(9) + 1;
			
			while(CPU_position.contains(CpuPos) ||  Playerposition.contains(CpuPos)) {
				CpuPos = rand.nextInt(9)+1;
			}
			
			Item_placement(gameboard,CpuPos,"cpu");
			
			printboard(gameboard);
			
			victory = Gamecheck();
			if(victory.length() > 0) {
				System.out.println(victory);
				break;
				}
			
			}
	}
	static void printboard(char[][]board) {
		for(char[] row : board) {
			for(char col : row) {
				System.out.print(col);
			}
			System.out.println("");
		}
	}
	
	static void Item_placement(char[][] Board, int pos , String user) {
		char symbol = ' ';//Default
		if(user.equals("player")){
			symbol = 'X';
			Playerposition.add(pos);
		}
		else if(user . equals("cpu")) {
			symbol = 'O';
			CPU_position.add(pos);
		}
		switch(pos) {
			case 1:Board[0][0] = symbol;
				break;
			case 2:Board[0][2] = symbol;
			break;
			case 3:Board[0][4] = symbol;
			break;
			case 4:Board[2][0] = symbol;
			break;
			case 5:Board[2][2] = symbol;
			break;
			case 6:Board[2][4] = symbol;
			break;
			case 7:Board[4][0] = symbol;
			break;
			case 8:Board[4][2] = symbol;
			break;
			case 9:Board[4][4] = symbol;
			break;
			default:
				break;
		}
		
	}
	static String  Gamecheck() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List firstCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List lastCol = Arrays.asList(3,6,9);
		List Cross1 = Arrays.asList(1,5,9);
		List Cross2 = Arrays.asList(3,5,7);
		//Creatinga List that Stores all the above lists in 1;
		List<List> win_chance = new ArrayList<List>();
		win_chance.add(topRow);
		win_chance.add(midRow);
		win_chance.add(bottomRow);
		win_chance.add(firstCol);
		win_chance.add(midCol);
		win_chance.add(lastCol);
		win_chance.add(Cross1);
		win_chance.add(Cross2);
		for(List check_list :win_chance) {
			if(Playerposition.containsAll(check_list)) {
				return "Congratulation! You've WON :)!";
			}
			else if(CPU_position.containsAll(check_list)) {
				return "CPU wins! better Luck Next Time :(";
			}
			else if(CPU_position.size() + Playerposition.size() == 9) {
				return "That's a TIE %";
			}
		}
		return "";
	}

}
