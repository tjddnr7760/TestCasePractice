import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
}
