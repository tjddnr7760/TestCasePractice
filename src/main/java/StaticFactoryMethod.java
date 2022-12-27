import java.time.LocalDate;

// 자신의 클래스 안에서 정적 팩터리 메서드를 만드는 경우
public class StaticFactoryMethod {
    private int inform1;
    private int inform2;

    public int getInform1() {
        return inform1;
    }

    public int getInform2() {
        return inform2;
    }

    private StaticFactoryMethod(int inform1, int inform2){
        this.inform1 = inform1;
        this.inform2 = inform2;
    }

    public static StaticFactoryMethod create(int inform1, int inform2) {
        return new StaticFactoryMethod(inform1, inform2);
    }
}

class Main {
    void example(int a, int b) {
        StaticFactoryMethod staticfactorymethod = StaticFactoryMethod.create(a, b);
    }
}

// 빌더 클래스의 정적 팩터리 메서드를 호출하는 경우
class PayData {
    private int moneyAmount;
    private LocalDate localdate;

    private PayData() {

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
        private PayData paydata = new PayData();

        public Builder createMoney(int moneyAmount) {
            paydata.moneyAmount = moneyAmount;
            return this;
        }

        public Builder createLocalDate(LocalDate localdate) {
            paydata.localdate = localdate;
            return this;
        }

        public PayData build() {
            return paydata;
        }
    }
}

class Main2 {
    public void builderPractice() {
        PayData paydata = PayData.builder()
                .createMoney(10_000)
                .createLocalDate(LocalDate.of(2020,1,12))
                .build();

        LocalDate date = paydata.getLocaldate();
    }
}
