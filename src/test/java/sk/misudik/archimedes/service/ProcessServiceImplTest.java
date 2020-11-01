package sk.misudik.archimedes.service;

import org.junit.jupiter.api.Test;
import sk.misudik.archimedes.repository.impl.DataRepositoryImpl;
import sk.misudik.archimedes.repository.impl.OutputRepositoryImpl;
import sk.misudik.archimedes.service.impl.ProcessServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static sk.misudik.archimedes.repository.OutputRepository.OUTPUT_PATH;

class ProcessServiceImplTest {

    @Test
    void processTest() {
        var output = new ProcessServiceImpl(new DataRepositoryImpl(), new OutputRepositoryImpl()).process();
        assertNotNull(this.getClass().getClassLoader().getResourceAsStream(OUTPUT_PATH));
    }

}