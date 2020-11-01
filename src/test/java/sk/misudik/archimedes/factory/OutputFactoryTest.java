package sk.misudik.archimedes.factory;

import org.junit.jupiter.api.Test;
import sk.misudik.archimedes.repository.DataRepository;
import sk.misudik.archimedes.repository.DataRepositoryImpl;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutputFactoryTest {

    private final DataRepository repository = new DataRepositoryImpl();

    @Test
    void outputTest() throws IOException {
        var calls = repository.getCalls();
        var operators = repository.getOperators();
        assertNotNull(OutputFactory.of(calls, operators));
    }

}
