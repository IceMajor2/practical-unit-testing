package exercise_10_8_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction setupConstructor() {
        return new Transaction(1, State.OK, true, "Message", "123ID");
    }

    Transaction setupSetters() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setState(State.OK);
        transaction.setRetryAllowed(true);
        transaction.setMessage("Message");
        transaction.setBillingId("123ID");
        return transaction;
    }

    Transaction setupBuilder() {
        TransactionBuilder builder = new TransactionBuilder();
        return builder
                .withId(1)
                .withState(State.OK)
                .withRetryAllowed(true)
                .withMessage("Message")
                .withBillingId("123ID")
                .build();
    }

    @Test
    void setupTest() {
        Transaction constructor = setupConstructor();
        Transaction setters = setupSetters();
        Transaction builder = setupBuilder();

        assertEquals(constructor, setters);
        assertEquals(constructor, builder);
        assertEquals(setters, builder);
    }

}