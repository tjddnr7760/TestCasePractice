import java.time.LocalDate;
import java.time.YearMonth;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        int addedMonths = paydata.getMoneyAmount() / 10_000;
        if (paydata.getFirstBillingDate() != null) {
            LocalDate candidate = paydata.getLocaldate().plusMonths(addedMonths);
            if (candidate.getDayOfMonth() != paydata.getFirstBillingDate().getDayOfMonth()) {
                if (YearMonth.from(candidate).lengthOfMonth() < paydata.getFirstBillingDate().getDayOfMonth()) {
                    return candidate.withDayOfMonth(YearMonth.from(candidate).lengthOfMonth());
                }
                return candidate.withDayOfMonth(paydata.getFirstBillingDate().getDayOfMonth());
            }
        }
        return paydata.getLocaldate().plusMonths(addedMonths);
    }
}
