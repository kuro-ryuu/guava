public class PalindromeChecker {

    public boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned)
                .reverse()
                .toString();

        return cleaned.equals(reversed);
    }
}