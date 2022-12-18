/**
 *  요구사항 정리
 *
 *  구현 목표 : 납부한 금액을 기준으로 서비스 만료일을 계산하는 기능을 구현하여라
 *  규칙
 *  1. 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달뒤가 서비스 만료일이 된다.
 *  2. 2개월 이상 요금을 납부할 수 있다.
 *  3. 10만원을 납부하면 서비스를 1년 제공한다.
 *
 */

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentExpirationCalculatorTest {
    @Test
    void pay_10Kwon_AfterMonth_ExpirationDay() {
        PaymentExpirationCalculator cal = new PaymentExpirationCalculator();
        int moneyAmount = 10000;
        LocalDate date = LocalDate.of(2019, 3, 1);
        LocalDate result = cal.expiaryDate(date, moneyAmount);
        assertEquals(LocalDate.of(2019,4,1), result);

        LocalDate date2 = LocalDate.of(2019,5,5);
        LocalDate result2 = cal.expiaryDate(date2, moneyAmount);
        assertEquals(LocalDate.of(2019,6,5), result2);
    }
}
