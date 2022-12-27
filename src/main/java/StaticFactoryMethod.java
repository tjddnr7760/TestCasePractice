import java.time.LocalDate;

// 자신의 클래스 안에서 정적 팩터리 메서드를 만드는 경우
// 첫번째 연습
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

// 두번째 연습
class StaticFactoryMethod2 {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    private StaticFactoryMethod2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static StaticFactoryMethod2 create(int a, int b) {
        return new StaticFactoryMethod2(a, b);
    }
}

class Main2 {
    StaticFactoryMethod2 factory = StaticFactoryMethod2.create(1, 2);
}

// 빌더 클래스의 정적 팩터리 메서드를 호출하는 경우
// 첫번째 연습
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

class Main3 {
    public void builderPractice() {
        PayData paydata = PayData.builder()
                .createMoney(10_000)
                .createLocalDate(LocalDate.of(2020,1,12))
                .build();

        LocalDate date = paydata.getLocaldate();
    }
}

// 두번째 연습
class PayData2 {
    private int moneyAmount;
    private LocalDate localdate;

    private PayData2() {

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
        PayData2 paydata2 = new PayData2();

        public Builder createMoneyAmount(int moneyAmount) {
            paydata2.moneyAmount = moneyAmount;
            return this;
        }

        public Builder createLocalDate(LocalDate localdate) {
            paydata2.localdate = localdate;
            return this;
        }

        public PayData2 build() {
            return paydata2;
        }
    }
}

class Main4 {
    PayData2 paydata = PayData2.builder()
            .createMoneyAmount(10_000)
            .createLocalDate(LocalDate.of(1000,2,2))
            .build();
}