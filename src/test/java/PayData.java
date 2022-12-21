/**
 *  빌더 패턴을 적용한 클래스 생성
 *  함수의 매개변수가 너무 많을때, 객체를 대신 전달하여 매개변수의 수를 줄인다.
 *  이너 클래스를 만들어 객체를 빌드할때 어떤 변수가 어떤 변수인지
 *  알아볼수 있으면서 객체를 생성한다.
 */

import java.time.LocalDate;

public class PayData {
    private LocalDate paymentDay;
    private int moneyAmount;

    private PayData() {}

    public PayData(LocalDate paymentDay, int moneyAmount) {
        this.paymentDay = paymentDay;
        this.moneyAmount = moneyAmount;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        public Builder paymentDay(LocalDate paymentDay) {
            data.paymentDay = paymentDay;
            return this;
        }

        public Builder moneyAmount(int moneyAmount) {
            data.moneyAmount = moneyAmount;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
