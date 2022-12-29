/**
 *  요구사항 정리
 *
 *  구현 목표 : 납부한 금액을 기준으로 서비스 만료일을 계산하는 기능을 구현하여라
 *  규칙
 *  1. 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달뒤가 서비스 만료일이 된다.
 *  2. 2개월 이상 요금을 납부할 수 있다.
 *  3. 10만원을 납부하면 서비스를 1년 제공한다.
 *
 *  리팩터링 - 빌더 패턴
 *  매개변수가 많은 생성자를 만들때 해당 패턴을 사용하여 빌드하여 객체를 생성할 수 있다.
 *  static class로 생성하기 때문에 따로 객체를 만들 필요가 없다.
 *  생성자 변수를 지정한 뒤, 함수를 구현하여 변수를 통해 값을 선언하는 형태로 한다.
 *
 */

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentExpirationCalculatorTest {
    private static final PaymentExpirationCalculator cal = new PaymentExpirationCalculator();

    @Test
    void pay_10Kwon_After_Month_ExpirationDay() {
        expectedExpiryDate(
                PayData.builder()
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2021,4,5))
                        .build(),
                LocalDate.of(2021,5, 5)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2022,6,7))
                        .build(),
                LocalDate.of(2022,7,7)
        );
    }

    @Test
    void exception_DueDate_Expiry_NotEqual() {
        expectedExpiryDate(
                PayData.builder()
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2019,1,31))
                        .build(),
                LocalDate.of(2019,2,28)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2019,5,31))
                        .build(),
                LocalDate.of(2019,6,30)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2020,1, 31))
                        .build(),
                LocalDate.of(2020,2,29)
        );
    }

    @Test
    void firstBilling_ExpiryDate_NotEquals_PayMore() {
        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,1,31))
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2019,2,28))
                        .build(),
                LocalDate.of(2019,3,31)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,1,30))
                        .inputMoneyAmount(10_000)
                        .inputBillingDate(LocalDate.of(2019,2,28))
                        .build(),
                LocalDate.of(2019, 3, 30)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,5,31))
                        .inputBillingDate(LocalDate.of(2019,6,30))
                        .inputMoneyAmount(10_000)
                        .build(),
                LocalDate.of(2019,7,31)
        );
    }

    @Test
    void pay_20KwonMore_After_ExpirationDay() {
        expectedExpiryDate(
                PayData.builder()
                        .inputBillingDate(LocalDate.of(2019,3,1))
                        .inputMoneyAmount(20_000)
                        .build(),
                LocalDate.of(2019,5,1)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputBillingDate(LocalDate.of(2019,3,1))
                        .inputMoneyAmount(30_000)
                        .build(),
                LocalDate.of(2019,6,1)
        );
    }

    @Test
    void differ_FirstBiling_BillingDate_20kwon_Higer() {
        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,1,31))
                        .inputBillingDate(LocalDate.of(2019,2,28))
                        .inputMoneyAmount(20_000)
                        .build(),
                LocalDate.of(2019,4,30)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,1,31))
                        .inputBillingDate(LocalDate.of(2019,2,28))
                        .inputMoneyAmount(40_000)
                        .build(),
                LocalDate.of(2019,6,30)
        );

        expectedExpiryDate(
                PayData.builder()
                        .inputFirstBillingDate(LocalDate.of(2019,3,31))
                        .inputBillingDate(LocalDate.of(2019,4,30))
                        .inputMoneyAmount(30_000)
                        .build(),
                LocalDate.of(2019,7,31)
        );
    }

    @Test
    void pay_100kwon_1Year() {
        expectedExpiryDate(
                PayData.builder()
                        .inputBillingDate(LocalDate.of(2019,1,28))
                        .inputMoneyAmount(100_000)
                        .build(),
                LocalDate.of(2020,1,28)
        );
    }

    private void expectedExpiryDate(PayData paydata, LocalDate endDate) {
        PaymentExpirationCalculator cal = new PaymentExpirationCalculator();
        LocalDate expDate = cal.expiaryDate(paydata);
        assertEquals(expDate, endDate);
    }
}
