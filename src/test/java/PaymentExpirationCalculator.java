import java.time.LocalDate;

public class PaymentExpirationCalculator {
    public LocalDate expiaryDate(LocalDate date, int moneyAmount) {
        return date.plusMonths(1);
    }
}
