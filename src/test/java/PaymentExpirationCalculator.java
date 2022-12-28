import java.time.LocalDate;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        return paydata.getLocaldate().plusMonths(1);
    }
}
