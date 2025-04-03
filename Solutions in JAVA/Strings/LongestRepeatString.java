public class LongestRepeatString {
    public static int longestSubstring(String str, int k) {
        int maxFreq = 0;
        int maxLen = 0;
        int right = 0;
        int left = 0;
        int freq[] = new int[26];
        int n = str.length();
        for(right =0;right<n;right++){
            freq[str.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,freq[str.charAt(right)-'A']);

            int windowSize = right-left+1;
            // this will tell of there is another char in between
            int changesNeed = windowSize - maxFreq;
            if(changesNeed > k){
                freq[str.charAt(left)-'A']--;
                left++;
            }
            maxLen  = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
	 public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(longestSubstring(str, k)); // Output: 4
    }
}
