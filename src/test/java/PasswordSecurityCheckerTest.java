/**
 *  요구사항 정리
 *
 *  개요 : 문자열을 검사해서 규칙을 준수하는지에 따라 암호를 '약함', '보통', '강함'
 *  으로 구분한다.
 *
 *  규칙 :   1. 길이가 8글자 이상
 *          2. 0 ~ 9 사이의 숫자
 *          3. 대문자 포함
 *
 *  판단 :   1. 3개의 규칙을 모두 충족하면 암호는 강함이다.
 *          2. 2개의 규칙을 충족하면 암호는 보통이다.
 *          3. 1개의 규칙을 충족하면 암호는 약함이다.
 *
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordSecurityCheckerTest {
    @Test
    void is_AllTestPassed_Strong() {
        PasswordSecurityChecker checker = new PasswordSecurityChecker();
        SecurityLevel level = checker.check("ab12!@AB");
        assertEquals(SecurityLevel.STRONG, level);
        SecurityLevel second_level = checker.check("abc1!Add");
        assertEquals(SecurityLevel.STRONG, second_level);
    }
}
