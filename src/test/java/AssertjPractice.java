import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
