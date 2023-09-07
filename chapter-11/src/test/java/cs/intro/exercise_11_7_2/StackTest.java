package cs.intro.exercise_11_7_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    private Stack<Double> SUT = new Stack<>();

    @Test
    void shouldReturnLastItemOnPop() {
        SUT.push(5d);
        SUT.push(9.1);
        SUT.push(3.14);

        assertThat(SUT.pop()).isEqualTo(3.14);
        assertThat(SUT.pop()).isEqualTo(9.1);

        SUT.push(0.111);

        assertThat(SUT.pop()).isEqualTo(0.111);
    }

    @Test
    void shouldThrowExceptionOnPopWhenEmpty() {

    }

    @Test
    void shouldDecreaseSizeOnPop() {

    }

    @Test
    void shouldIncreaseSizeOnPush() {

    }

    @Test
    void shouldThrowExceptionOnPushingNullObject() {

    }
}