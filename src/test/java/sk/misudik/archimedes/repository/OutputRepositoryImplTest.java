package sk.misudik.archimedes.repository;

import org.junit.jupiter.api.Test;
import sk.misudik.archimedes.model.output.Output;
import sk.misudik.archimedes.repository.impl.OutputRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutputRepositoryImplTest {

    private OutputRepository repository = new OutputRepositoryImpl();

    @Test
    void save() {
        Output output = new Output();
        repository.save(output);
        assertNotNull(this.getClass().getClassLoader().getResourceAsStream("data/output.json"));
    }
}