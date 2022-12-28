import java.time.LocalDate;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        if(paydata.getFirstBillingDate() != null) {
            LocalDate candidate = paydata.getLocaldate().plusMonths(1);
            if(candidate.getDayOfMonth() != paydata.getFirstBillingDate().getDayOfMonth()) {
                return candidate.withDayOfMonth(paydata.getFirstBillingDate().getDayOfMonth());
            }
        }
        return paydata.getLocaldate().plusMonths(1);
    }
}
