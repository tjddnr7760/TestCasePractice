import java.time.LocalDate;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        return paydata.getPaymentDay().plusMonths(1);
    }
}
