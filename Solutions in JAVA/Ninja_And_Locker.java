import java.util.* ;
import java.io.*; 
import java.lang.*;
class Ninja_And_Locker {
	public static int savedCash(int n, ArrayList<Integer> cash, int m, ArrayList<Integer> locker) {
		Collections.sort(cash);
		int[] smallLocker = new int[m];
		smallLocker[0] = locker.get(0);
		for(int i=1;i<m;i++){
			smallLocker[i] = Math.min(locker.get(i), smallLocker[i-1]);
		}
		int cashIndex = 0;
		int ans = 0;
		for(int i=m-1;i>=0 && cashIndex<n;i--){
			while(cashIndex<n && cash.get(cashIndex) <=smallLocker[i]){
				ans++;
				cashIndex++;
				break;
			}
		}
		return ans;
	}
	// Example Test Case
    public static void main(String[] args) {
        int n = 4, m = 3;
        ArrayList<Integer> cash = new ArrayList<>(Arrays.asList(4, 3, 2, 5));
        ArrayList<Integer> locker = new ArrayList<>(Arrays.asList(4, 2, 3));

        System.out.println("Output is = "+savedCash(n, cash, m, locker));  // Output: 2
    }
}

