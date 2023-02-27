import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;

public class AssertjPractice {

    @DisplayName("assertThat isInstanceOf 체이닝 메서드 예시")
    @Test
    void test_isInstanceOf() {
        //given
        String str = "Hello!";

        //when, then
        assertThat(str).isInstanceOf(Object.class);
        //assertThat(str).isInstanceOf(Integer.class);
    }

    @DisplayName("asInstanceOf 메서드 예시")
    @Test
    void test_asInstanceOf() {
        //given
        Object obj = 123;

        //when, then
        assertThat(obj).asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(123);
    }

    @DisplayName("asList 메서드 예시")
    @Test
    void test_asList() {
        //given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //when, then
        System.out.println("1 " + assertThat(list).contains(1));
        System.out.println("2 " + assertThat(list).asList().contains(1));
        //asList 를 굳이 사용하지 않아도 되지만 가독성을 위해 사용한다고 이해한다.
    }

    @DisplayName("assertionError 메서드 예시")
    @Test
    void test_assertionError() {
        //given

        //when, then
        try {
            //assertThat(actual).isEqualTo(expected);
        } catch (AssertionError e) {
            //Assertions.assertionError(e.getMessage());
            //에러 발생시 AssertError throw하는 메서드이다. AbstractAssert 추상클래스 구현시 오버라이딩 해서
            //에러 출력 메서드 구현해주면 된다.
        }
    }

    @DisplayName("예외처리 방법")
    @Test
    void test_assertThatThrownBy() {
        assertThatThrownBy(() -> just_divide(10, 0))
                .isExactlyInstanceOf(Exception.class);

        assertThatThrownBy(() -> just_divide(15, 0))
                .isInstanceOf(Exception.class);

        assertThatThrownBy(() -> runtime_divide(10, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runtime_divide(15, 0))
                .isInstanceOf(RuntimeException.class);
    }

    // Exception이 런타임 에러가 아니기때문에 컴파일시 throws가 없으면 컴파일 오류가 난다.
    private int just_divide(int divided, int divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception();
        }
        return divided / divisor;
    }

    // Exception이 런타임 에러임으로 컴파일시 오류는 나지 않고 실행시 오류가 발생된다.
    private int runtime_divide(int divided, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        return divided / divisor;
    }

    @DisplayName("Arguments 인터페이스 구현하여 파라미터화 테스트")
    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void test_Parameterized_Test(String str, int expect) {
        assertThat(str.length()).isEqualTo(expect);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("abc", 3),
                Arguments.of("be", 2),
                Arguments.of("kkkk", 4),
                Arguments.of("arrer", 5)
        );
    }
}
