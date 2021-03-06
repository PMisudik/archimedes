package sk.misudik.archimedes.repository;

import org.junit.jupiter.api.Test;
import sk.misudik.archimedes.model.output.Output;
import sk.misudik.archimedes.model.output.Outputs;
import sk.misudik.archimedes.repository.impl.OutputRepositoryImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static sk.misudik.archimedes.repository.OutputRepository.OUTPUT_PATH;

class OutputRepositoryImplTest {

    private OutputRepository repository = new OutputRepositoryImpl();

    @Test
    void save() throws IOException {
        var output = new Output();
        output.setDate("2020-05-08");
        output.setId("20");
        output.setNumber("+42191068925");
        output.setOperator("Vodafone");
        output.setRiskScore(1.0f);
        var outputs = new Outputs();
        outputs.setData(List.of(output));
        repository.save(outputs);
        var file = Paths.get(OUTPUT_PATH).toFile();
        assertTrue(file.exists());
    }
}