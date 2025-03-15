import java.util.*;
import java.io.*;

public class FastestNinja {
    public static boolean fastestNinja(int n, int x, int y, ArrayList<ArrayList<Integer>> position) {
        int bobsDistance = Math.abs(x) + Math.abs(y);
        for (int i = 0; i < n; i++) {
            int xCoordinate = Math.abs(position.get(i).get(0) - x);
            int yCoordinate = Math.abs(position.get(i).get(1) - y);
            int friendDistance = xCoordinate + yCoordinate;
            if (friendDistance <= bobsDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the number of friends:");
        int N = Integer.parseInt(br.readLine());
        
        System.out.println("Enter Alice's position (X Y):");
        String[] alicePos = br.readLine().split(" ");
        int X = Integer.parseInt(alicePos[0]);
        int Y = Integer.parseInt(alicePos[1]);
        
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
        System.out.println("Enter the positions of friends:");
        for (int i = 0; i < N; i++) {
            String[] pos = br.readLine().split(" ");
            ArrayList<Integer> friendPos = new ArrayList<>();
            friendPos.add(Integer.parseInt(pos[0]));
            friendPos.add(Integer.parseInt(pos[1]));
            positions.add(friendPos);
        }
        
        System.out.println("Result: " + (fastestNinja(N, X, Y, positions) ? 1 : 0));
    }
}
