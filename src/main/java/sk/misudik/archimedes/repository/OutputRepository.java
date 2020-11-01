package sk.misudik.archimedes.repository;

import sk.misudik.archimedes.model.output.Outputs;

import java.io.IOException;

public interface OutputRepository {

    String OUTPUT_PATH = "target/output.csv";

    void save(Outputs outputs) throws IOException;

}
