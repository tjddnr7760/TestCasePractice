public class PasswordSecurityChecker {
    public SecurityLevel check(String word) {
        if(word.length() < 8) {
            return SecurityLevel.NORMAL;
        }
        return  SecurityLevel.STRONG;
    }
}
