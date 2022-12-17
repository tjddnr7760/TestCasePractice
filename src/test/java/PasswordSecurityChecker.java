public class PasswordSecurityChecker {

    public SecurityLevel check(String word) {
        if(word == null) {
            return SecurityLevel.INVALID;
        }
        if (isShort(word) || !containsNumber(word)) {
            return SecurityLevel.NORMAL;
        }
        return SecurityLevel.STRONG;
    }

    private boolean isShort(String word) {
        return word.length() < 8;
    }

    private boolean containsNumber(String word) {
        for (char ch : word.toCharArray()) {
            if (isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}