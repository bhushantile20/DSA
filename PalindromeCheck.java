public class PalindromeCheck {
    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println(input + " is palindrome? " + isPalindrome(input)); // Output: true
    }
}
