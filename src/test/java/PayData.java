import java.time.LocalDate;

public class PayData {
    private LocalDate firstBillingDate;
    private int moneyAmount;
    private LocalDate localdate;

    private PayData() {

    }

    private PayData(LocalDate firstBillingDate, int moneyAmount, LocalDate localdate) {
        this.firstBillingDate = firstBillingDate;
        this.moneyAmount = moneyAmount;
        this.localdate = localdate;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        PayData data = new PayData();

        public Builder inputFirstBillingDate(LocalDate firstBillingDate) {
            data.firstBillingDate = firstBillingDate;
            return this;
        }

        public Builder inputMoneyAmount(int moneyAmount) {
            data.moneyAmount = moneyAmount;
            return this;
        }

        public Builder inputLocalDate(LocalDate localdate) {
            data.localdate = localdate;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}