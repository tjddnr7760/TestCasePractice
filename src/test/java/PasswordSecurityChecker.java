public class PasswordSecurityChecker {

    public SecurityLevel check(String word) {
        if (word == null || word.isBlank()) {
            return SecurityLevel.INVALID;
        }

        if (!containsUppercaseLetters(word)) {
            return SecurityLevel.NORMAL;
        }

        if (isShort(word) || !containsNumber(word)) {
            return SecurityLevel.NORMAL;
        }
        return SecurityLevel.STRONG;
    }

    private boolean containsUppercaseLetters(String word) {
        return word.chars().anyMatch(Character::isUpperCase);
    }

    private boolean isShort(String word) {
        return word.length() < 8;
    }

    private boolean containsNumber(String word) {
        return word.chars().anyMatch(Character::isDigit);
    }
}
