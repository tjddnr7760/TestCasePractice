import java.time.LocalDate;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        int addedMonths = paydata.getMoneyAmount() / 10_000;
        if(paydata.getFirstBillingDate() != null) {
            LocalDate candidate = paydata.getLocaldate().plusMonths(addedMonths);
            if(candidate.getDayOfMonth() != paydata.getFirstBillingDate().getDayOfMonth()) {
                return candidate.withDayOfMonth(paydata.getFirstBillingDate().getDayOfMonth());
            }
        }
        return paydata.getLocaldate().plusMonths(addedMonths);
    }
}
