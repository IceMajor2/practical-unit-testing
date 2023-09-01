package exercise_10_8_1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class TestFixtureTest {

    private static Logger JUNIT_LOGGER;

    @BeforeAll
    static void beforeAll() {
        JUNIT_LOGGER = LoggerFactory.getLogger(TestFixtureTest.class);
        String logMessage = "Setting up JUnit's Logger class which will be used in this test class.";
        JUNIT_LOGGER.info(() -> logMessage);
    }

    @BeforeEach
    void beforeEach() {
        String logMessage = "Just informing you that this message will be shown before each test... " +
                "yes, even parameterized ones!";
        JUNIT_LOGGER.info(() -> logMessage);
    }

    @AfterAll
    static void afterAll() {
        String logMessage = "We're done! We can go home now.";
        JUNIT_LOGGER.info(() -> logMessage);
    }

    @AfterEach
    void afterEach() {
        String logMessage = "No matter what, this is a logged message after each test has been executed... " +
                "even, if not passed.";
        JUNIT_LOGGER.info(() -> logMessage);
    }

    @Test
    void testMethodA() {
        System.out.println("method A");
    }

    @Test
    void testMethodB() {
        System.out.println("method B");
    }

    @ParameterizedTest
    @ValueSource(chars = {'C', 'D', 'E', 'F'})
    void testMethods(char ch) {
        System.out.println("method " + ch);
    }

    @Test
    void testFailedJava() {
        assert 5 == 0;
    }

    @Test
    void testFailedAssertJ() {
        assertThat(5).isEqualTo(0);
    }

    @Test
    void testFailedJUnit() {
        assertEquals(5, 0);
    }
}
