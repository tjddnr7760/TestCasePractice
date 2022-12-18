/**
 *  요구사항 정리
 *
 *  개요 : 문자열을 검사해서 규칙을 준수하는지에 따라 암호를 '약함', '보통', '강함'
 *  으로 구분한다. 규칙을 충족하면 암호는 보통이다.
 *          3. 1개의
 *  *
 *  *  규칙 :   1. 길이가 8글자 이상
 *  *          2. 0 ~ 9 사이의 숫자를 포함
                *  *          3. 대문자 포함
 *  *
 *  *  판단 :   1. 3개의 규칙을 모두 충족하면 암호는 강함이다.
 *  *          2. 2개의 규칙을 충족하면 암호는 약함이다.
                *
 */
import org.junit.jupiter.api.Test;

import java.security.Security;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordSecurityCheckerTest {
    private PasswordSecurityChecker checker = new PasswordSecurityChecker();

    private void assertStrength(String password, SecurityLevel expStr) {
        SecurityLevel level = checker.check(password);
        assertEquals(expStr, level);
    }

    @Test
    void is_AllTestPassed_Strong() {
        assertStrength("ab12!@AB", SecurityLevel.STRONG);
        assertStrength("abc1!Add", SecurityLevel.STRONG);
    }

    @Test
    void is_passAllTestExceptLength_Normal() {
        assertStrength("ab12!@A", SecurityLevel.NORMAL);
        assertStrength("Ab12!c", SecurityLevel.NORMAL);
    }

    @Test
    void is_passAllTestExceptNumberConditions_Normal() {
        assertStrength("ab!@ABqwer", SecurityLevel.NORMAL);
    }

    @Test
    void nullInput_INVALID() {
        assertStrength(null, SecurityLevel.INVALID);
    }

    @Test
    void emptyInput_INVALID() {
        assertStrength("", SecurityLevel.INVALID);
    }

    @Test
    void is_passAllTestExceptUppercase_Normal() {
        assertStrength("ab12!@df", SecurityLevel.NORMAL);
    }

    @Test
    void is_OneCondition_Length_Weak() {
        assertStrength("abdefghi", SecurityLevel.WEAK);
    }

    @Test
    void is_OneCondition_Number_Weak() {
        assertStrength("123", SecurityLevel.WEAK);
    }

    @Test
    void is_OneCondition_Uppercase_Weak() {
        assertStrength("UABCDE", SecurityLevel.WEAK);
    }

    @Test
    void is_NoConditionsSatisfied_Weak() {
        assertStrength("abc", SecurityLevel.WEAK);
    }
}
