public class PasswordSecurityChecker {
    public SecurityLevel check(String word) {
        if (word == null || word.isBlank()) {
            return SecurityLevel.INVALID;
        }

        int conditionCounts = checkConditionsCount(word);

        if(conditionCounts <= 1) {
            return SecurityLevel.WEAK;
        }
        if (conditionCounts == 2) {
            return SecurityLevel.NORMAL;
        }

        return SecurityLevel.STRONG;
    }

    private int checkConditionsCount(String word) {
        int conditionCounts = 0;

        if(containsUppercaseLetters(word)) {
            conditionCounts++;
        }
        if(isLength(word)) {
            conditionCounts++;
        }
        if(containsNumber(word)) {
            conditionCounts++;
        }

        return conditionCounts;
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
