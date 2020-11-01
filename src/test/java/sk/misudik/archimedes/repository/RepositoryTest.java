package sk.misudik.archimedes.repository;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RepositoryTest {

    private final DataRepository repository = new DataRepositoryImpl();

    @Test
    void callsTest() throws IOException {
        var calls = repository.getCalls();
        assertNotNull(calls);
        assertEquals(2, calls.getData().size());
    }

    @Test
    void operatorsTest() throws IOException {
        var operators = repository.getOperators();
        assertNotNull(operators);
        assertEquals(2, operators.getData().size());
    }

}
