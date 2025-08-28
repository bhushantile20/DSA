public class LongestCommonPrefix {

    // Function to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Assume the first string is the prefix
        String prefix = strs[0];

        // Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {
            // Keep reducing prefix until it matches the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Main method to test
    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(words));

        String[] words2 = {"dog", "racecar", "car"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(words2));
    }
}
