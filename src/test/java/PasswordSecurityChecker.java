public class PasswordSecurityChecker {

    public SecurityLevel check(String word) {
        if (word == null || word.isBlank()) {
            return SecurityLevel.INVALID;
        }

        boolean containsUppercase = containsUppercaseLetters(word);
        boolean lengthcodition = isLength(word);
        boolean containsNumber = containsNumber(word);

        if(lengthcodition && !containsUppercase && !containsNumber) {
            return SecurityLevel.WEAK;
        }

        if(!lengthcodition && !containsUppercase && containsNumber) {
            return SecurityLevel.WEAK;
        }

        if(!lengthcodition && containsUppercase && !containsNumber) {
            return SecurityLevel.WEAK;
        }

        if (!containsUppercaseLetters(word)) {
            return SecurityLevel.NORMAL;
        }

        if (!isLength(word)) {
            return SecurityLevel.NORMAL;
        }

        if (!containsNumber(word)) {
            return SecurityLevel.NORMAL;
        }

        return SecurityLevel.STRONG;
    }

    private boolean containsUppercaseLetters(String word) {
        return word.chars().anyMatch(Character::isUpperCase);
    }

    private boolean isLength(String word) {
        return word.length() >= 8;
    }

    private boolean containsNumber(String word) {
        return word.chars().anyMatch(Character::isDigit);
    }
}
