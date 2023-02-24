import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertjPractice {

    @DisplayName("assertThat instanceOf 체이닝 메서드 예시")
    @Test
    void test_instanceOf() {
        //given
        String str = "Hello!";

        //when, then
        assertThat(str).isInstanceOf(Object.class);
        //assertThat(str).isInstanceOf(Integer.class);
    }
}
