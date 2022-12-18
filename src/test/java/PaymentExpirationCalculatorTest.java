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
    private static final PaymentExpirationCalculator cal = new PaymentExpirationCalculator();

    private void expectedExpiryDate(LocalDate startDate, int moneyAmount, LocalDate endDate) {
        LocalDate date = cal.expiaryDate(startDate, moneyAmount);
        assertEquals(endDate, date);
    }

    @Test
    void pay_10Kwon_AfterMonth_ExpirationDay() {
        expectedExpiryDate(
                LocalDate.of(2019,3,1),
                10_000,
                LocalDate.of(2019,4,1)
        );

        expectedExpiryDate(
                LocalDate.of(2019,5,5),
                10_000,
                LocalDate.of(2019,6,5)
        );
    }
}
