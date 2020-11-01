package sk.misudik.archimedes.service;

import org.junit.jupiter.api.Test;
import sk.misudik.archimedes.repository.impl.DataRepositoryImpl;
import sk.misudik.archimedes.repository.impl.OutputRepositoryImpl;
import sk.misudik.archimedes.service.impl.ProcessServiceImpl;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static sk.misudik.archimedes.repository.OutputRepository.OUTPUT_PATH;

class ProcessServiceImplTest {

    @Test
    void processTest() throws IOException {
        var outputs = new ProcessServiceImpl(new DataRepositoryImpl(), new OutputRepositoryImpl()).process();
        var file = Paths.get(OUTPUT_PATH).toFile();
        assertTrue(file.exists());
        assertNotNull(outputs);
    }

}