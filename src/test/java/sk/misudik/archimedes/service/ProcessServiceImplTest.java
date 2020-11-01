package sk.misudik.archimedes.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessServiceImplTest {

    @Test
    void processTest() {
        assertNotNull(this.getClass().getClassLoader().getResourceAsStream("data/output.json"));
    }

}