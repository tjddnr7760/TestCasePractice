import java.time.LocalDate;
import java.time.YearMonth;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(PayData paydata) {
        int addedMonths = paydata.getMoneyAmount() / 10_000;
        if (paydata.getFirstBillingDate() != null) {
            return expiryDateUsingFirstDate(paydata, addedMonths);
        }
        else {
            return paydata.getLocaldate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstDate(PayData paydata, int addedMonths) {
        LocalDate candidate = paydata.getLocaldate().plusMonths(addedMonths);
        final int dayOfMonthFirstBilling = paydata.getFirstBillingDate().getDayOfMonth();
        if (candidate.getDayOfMonth() != dayOfMonthFirstBilling) {
            final int dayOfMonthCandidate = YearMonth.from(candidate).lengthOfMonth();
            if (dayOfMonthCandidate < dayOfMonthFirstBilling) {
                return candidate.withDayOfMonth(dayOfMonthCandidate);
            }
            return candidate.withDayOfMonth(dayOfMonthFirstBilling);
        } else {
            return candidate;
        }
    }
}
