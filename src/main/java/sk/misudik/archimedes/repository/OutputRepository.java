package sk.misudik.archimedes.repository;

import sk.misudik.archimedes.model.output.Output;

import java.io.IOException;

public interface OutputRepository {

    String OUTPUT_PATH = "target/output.csv";

    void save(Output output) throws IOException;

}
